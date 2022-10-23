package application.modelTest.menu;

import application.model.menu.GameWon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameWonTest {
    GameWon gameWon = new GameWon();

    @Test
    public void getEntryTest(){
        String string = gameWon.getEntry(0);
        assertEquals("PLAY AGAIN",string);
    }

    @Test
    public void getNumberEntriesTest(){
        int actualNumber = gameWon.getNumberEntries();
        assertEquals(2,actualNumber);
    }
}
