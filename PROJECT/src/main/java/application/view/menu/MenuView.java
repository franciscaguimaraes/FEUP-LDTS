package application.view.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.Menu;
import application.view.View;

public class MenuView extends View<Menu> {
    public MenuView(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(7, 4), "MENU", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(1, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
