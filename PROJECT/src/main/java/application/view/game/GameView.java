package application.view.game;

import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Element;
import application.view.View;

import java.util.List;

public class GameView extends View<BattleField> {

    public GameView(BattleField battleField) {
        super(battleField);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getMargins(), new MarginsView());
        drawElements(gui, getModel().getEnemies(), new EnemyView());
        drawElement(gui, getModel().getPlayer(), new PlayerView());
        drawElement(gui, getModel().getBullet(), new BulletView());
        drawElements(gui, getModel().getBombs(), new BombView());
        drawElements(gui, getModel().getCovers(), new CoversView());

        gui.drawText(new Position(0, 0), "LIVES: " + getModel().getPlayer().getLives(), "#FFD700");
        gui.drawText(new Position(11, 0), "POINTS: " + getModel().getPlayer().getPoints(), "#FFD700");

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementView<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementView<T> viewer) {
        viewer.draw(element, gui);
    }

}
