package application.viewTest.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.Instructions;
import application.view.menu.InstructionsView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InstructionsViewTest {
    private InstructionsView instructionsView = new InstructionsView(new Instructions());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        instructionsView.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceBar(new Position(9,3));
        Mockito.verify(gui, Mockito.times(1)).drawArrowLeft(new Position(7,8));
        Mockito.verify(gui, Mockito.times(1)).drawArrowRight(new Position(2,9));
    }
}
