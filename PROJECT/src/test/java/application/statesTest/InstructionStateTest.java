package application.statesTest;

import application.model.menu.Instructions;
import application.states.InstructionsState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InstructionStateTest {
    private InstructionsState instructionState;
    private Instructions transition;

    @BeforeEach
    void setUp(){
        transition = new Instructions();
        instructionState = new InstructionsState(transition);
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,instructionState.getModel());
    }

}
