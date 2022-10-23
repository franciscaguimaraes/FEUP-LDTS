package application.viewTest.game;

import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.*;
import application.view.game.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class GameViewTest {
    private GUI gui;
    private GameView viewer;

    @BeforeEach
    void setUp() {
        BattleField battleField = new BattleField(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameView(battleField);

        battleField.setMargins(Arrays.asList(new Margins(1, 2), new Margins(2, 3), new Margins(3, 4)));
        battleField.setEnemies(Arrays.asList(new Enemy(4, 5), new Enemy(5, 6)));
        battleField.setPlayer(new Player(5, 8));
        battleField.setBombs(Arrays.asList(new Bomb(1, 2), new Bomb(2, 3), new Bomb(3, 4)));
        battleField.setCovers(Arrays.asList(new Covers(1, 2), new Covers(2, 3), new Covers(3, 4)));
        battleField.setBullet(new Bullet(5,8));
    }

    @Test
    void drawMargins() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMargins(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawMargins(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawMargins(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawMargins(Mockito.any(Position.class));
    }

    @Test
    void drawEnemies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemies(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawEnemies(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawEnemies(Mockito.any(Position.class));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void drawBullet() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBullet(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawBullet(Mockito.any(Position.class));
    }

    @Test
    void drawCovers() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCovers(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawCovers(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawCovers(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawCovers(Mockito.any(Position.class));
    }

    @Test
    void drawBombs() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBombs(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawBombs(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawBombs(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawBombs(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
