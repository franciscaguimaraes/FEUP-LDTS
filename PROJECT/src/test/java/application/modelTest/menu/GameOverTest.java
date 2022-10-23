package application.modelTest.menu;

import application.model.menu.GameOver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverTest {

    GameOver gameOver = new GameOver();

    @Test
    public void getEntryTest(){
        String string = gameOver.getGameOverEntry(0);
        assertEquals("PLAY AGAIN",string);
    }

    @Test
    public void getNumberEntriesTest(){
        int actualNumber = gameOver.getNumberEntries();
        assertEquals(2,actualNumber);
    }
}
