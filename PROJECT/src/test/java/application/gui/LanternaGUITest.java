package application.gui;

import application.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawPlayer() {
        gui.drawPlayer(new Position(1, 1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "b");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawEnemies(){
        gui.drawEnemies(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 8));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "a");
    }

    @Test
    void drawMargins(){
        gui.drawMargins(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 136, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    void drawBullet(){
        gui.drawBullet(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(135, 21, 5));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "d");
    }

    @Test
    void drawBombs(){
        gui.drawBombs(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(135, 21, 5));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "c");
    }

    @Test
    void drawCovers(){
        gui.drawCovers(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(135, 21, 5));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    void drawArrowRight(){
        gui.drawArrowRight(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "f");
    }
    @Test
    void drawArrowLeft(){
        gui.drawArrowLeft(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "e");
    }

    @Test
    void drawSpaceBar(){
        gui.drawSpaceBar(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 2, "g");
    }

    @Test
    void testClear(){
        gui.clear();

        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();

        Mockito.verify(screen, Mockito.times(1)).close();
    }
}