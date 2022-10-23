package application.gui;

import application.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{

    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration)
            throws IOException{

        TerminalSize terminalSize = new TerminalSize(width,height + 1); // for LIVES
        DefaultTerminalFactory terminalFactory =
                new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();

        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/final.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), 'b', "#FFFFFF");
    }

    @Override
    public void drawMargins(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#0088ff");
    }

    @Override
    public void drawEnemies(Position position) {
        drawCharacter(position.getX(), position.getY(), 'a', "#00ff08");
    }

    @Override
    public void drawBullet(Position position) { drawCharacter(position.getX(), position.getY(), 'd', "#871505"); }

    @Override
    public void drawBombs(Position position) { drawCharacter(position.getX(), position.getY(), 'c', "#871505"); }

    @Override
    public void drawCovers(Position position) { drawCharacter(position.getX(), position.getY(),'#',"#871505");}

    @Override
    public void drawArrowRight(Position position){
        drawCharacter(position.getX(),position.getY(),'f', "#FFFFFF");
    }

    @Override
    public void drawArrowLeft(Position position){
        drawCharacter(position.getX(),position.getY(),'e', "#FFFFFF");
    }

    @Override
    public void drawSpaceBar(Position position){
        drawCharacter(position.getX(),position.getY(),'g', "#FFFFFF");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char shape, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + shape);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public ACT getNextAction() throws IOException {
        KeyStroke key = screen.pollInput();

        if (key == null) return ACT.NONE;

        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') { return ACT.QUIT; }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') { return ACT.SHOOT; }
        if (key.getKeyType() == KeyType.ArrowRight) { return ACT.RIGHT; }
        if (key.getKeyType() == KeyType.ArrowLeft) { return ACT.LEFT; }
        if (key.getKeyType() == KeyType.ArrowUp) { return ACT.UP; }
        if (key.getKeyType() == KeyType.ArrowDown) { return ACT.DOWN; }
        if (key.getKeyType() == KeyType.Enter) { return ACT.SELECT; }

        return ACT.NONE;
    }
}
