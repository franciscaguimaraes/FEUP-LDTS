package application.statesTest;

import application.model.menu.GameOver;
import application.states.GameOverState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOverStateTest {
    private GameOverState gameOverState;
    private GameOver transition;

    @BeforeEach
    void setUp() {
        transition = new GameOver();
        gameOverState = new GameOverState(transition);
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,gameOverState.getModel());
    }

}
