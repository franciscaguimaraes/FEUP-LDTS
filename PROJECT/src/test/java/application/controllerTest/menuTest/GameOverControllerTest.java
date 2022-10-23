package application.controllerTest.menuTest;

import application.Game;
import application.controller.menu.GameOverController;
import application.gui.GUI;
import application.model.menu.GameOver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameOverControllerTest {
    GameOverController goc;
    GameOver gameOver;
    Game game;

    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        gameOver = new GameOver();
        goc = new GameOverController(gameOver);
    }

    @Test
    void TestDownGameWon() throws IOException{
        goc.step(game, GUI.ACT.DOWN,0);

        gameOver.nextGameOverEntry();
        Assertions.assertEquals(gameOver,goc.getModel());
    }

    @Test
    void TestUpGameWon() throws IOException{
        goc.step(game, GUI.ACT.UP,0);

        gameOver.previousGameOverEntry();
        Assertions.assertEquals(gameOver,goc.getModel());
    }

    @Test
    void TestSelectGameWon() throws IOException{
        goc.step(game, GUI.ACT.SELECT,0);

        gameOver.isSelectedExit();
        Assertions.assertEquals(gameOver,goc.getModel());
    }

}
