package application.modelTest.menu;

import application.model.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    private Menu menu = new Menu();

    @Test
    public void checkNumberOfEntries(){
       int entries = menu.getNumberEntries();
       assertEquals(3, entries);
    }

    @Test
    public void checkEntries(){
        assertEquals("START", menu.getEntry(0));
    }

}
