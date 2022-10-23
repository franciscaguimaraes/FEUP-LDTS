package application.view.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.GameWon;
import application.view.View;

public class GameWonView extends View <GameWon> {

    public GameWonView(GameWon model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 4), "YOU WON!", "#FFFFFF");
        gui.drawText(new Position(6, 5), "WELL DONE", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(1, 15 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
