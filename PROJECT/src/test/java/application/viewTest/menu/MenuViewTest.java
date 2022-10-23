package application.viewTest.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.Menu;
import application.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MenuViewTest {
    private MenuView menuview = new MenuView(new Menu());
    private GUI gui = Mockito.mock(GUI.class);


    @Test
    void drawElements() {
        menuview.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(7, 4), "MENU", "#FFFFFF");
    }
}
