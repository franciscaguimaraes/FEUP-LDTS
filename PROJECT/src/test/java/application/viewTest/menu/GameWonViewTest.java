package application.viewTest.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.GameWon;
import application.view.menu.GameWonView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameWonViewTest {
    private GameWonView gameWonView = new GameWonView(new GameWon());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        gameWonView.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 4), "YOU WON!", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 5), "WELL DONE", "#FFFFFF");

    }
}
