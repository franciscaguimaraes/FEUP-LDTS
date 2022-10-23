package application.statesTest;

import application.model.menu.GameWon;
import application.states.GameWonState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameWonStateTest {
    private GameWonState gameWonState;
    private GameWon transition;

    @BeforeEach
    void setUp(){
        transition = new GameWon();
        gameWonState = new GameWonState(transition);
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,gameWonState.getModel());
    }

}
