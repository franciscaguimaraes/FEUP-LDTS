package application.modelTest.menu;

import application.model.menu.Instructions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsTest {
    Instructions instructions = new Instructions();

    @Test
    public void getEntryTest(){
        String string = instructions.getEntry();
        assertEquals("BACK",string);
    }
}
