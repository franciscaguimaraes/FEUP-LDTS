package application.statesTest;

import application.model.game.battlefield.BattleField;
import application.states.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameStateTest {
    private GameState gameState;
    private BattleField battleField;

    @BeforeEach
    void setUp(){
        gameState = new GameState(battleField);
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(battleField,gameState.getModel());
    }

}
