package application.controllerTest.menuTest;

import application.Game;
import application.controller.menu.GameWonController;
import application.gui.GUI;
import application.model.menu.GameWon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameWonControllerTest {
    GameWonController gwc;
    GameWon gameWon;
    Game game;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        gameWon = new GameWon();
        gwc = new GameWonController(gameWon);
    }

    @Test
    void TestDownGameWon() throws IOException{
        gwc.step(game, GUI.ACT.DOWN,0);

        gameWon.nextGameWonEntry();
        Assertions.assertEquals(gameWon,gwc.getModel());
    }

    @Test
    void TestUpGameWon() throws IOException{
        gwc.step(game, GUI.ACT.UP,0);

        gameWon.previousGameWonEntry();
        Assertions.assertEquals(gameWon,gwc.getModel());
    }

    @Test
    void TestSelectGameWon() throws IOException{
        gwc.step(game, GUI.ACT.SELECT,0);

        gameWon.isSelectedExit();
        Assertions.assertEquals(gameWon,gwc.getModel());
    }
}
