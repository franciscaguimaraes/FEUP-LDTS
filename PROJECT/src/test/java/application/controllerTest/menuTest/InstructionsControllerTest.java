package application.controllerTest.menuTest;

import application.Game;
import application.controller.menu.InstructionsController;
import application.gui.GUI;
import application.model.menu.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionsControllerTest {
    InstructionsController ic;
    Instructions instructions;
    Game game;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        instructions = new Instructions();
        ic = new InstructionsController(instructions);
    }

    @Test
    void TestSelectBackInstructions() throws IOException {
        ic.step(game, GUI.ACT.SELECT,0);

        instructions.isSelectedBack();
        Assertions.assertEquals(instructions, ic.getModel());
    }
}
