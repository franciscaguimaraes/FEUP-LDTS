package application.viewTest.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.GameOver;
import application.view.menu.GameOverView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverViewTest {
    private GameOverView gameOverView = new GameOverView(new GameOver());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        gameOverView.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 4), "YOU LOST :(", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "BETTER LUCK", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 6), "NEXT TIME", "#FFFFFF");
    }

}


