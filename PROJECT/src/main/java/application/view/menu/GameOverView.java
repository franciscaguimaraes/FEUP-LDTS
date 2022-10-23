package application.view.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.GameOver;
import application.view.View;

public class GameOverView extends View <GameOver> {

    public GameOverView(GameOver model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 4), "YOU LOST :(", "#FFFFFF");
        gui.drawText(new Position(5, 5), "BETTER LUCK", "#FFFFFF");
        gui.drawText(new Position(5, 6), "NEXT TIME", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(1, 15 + i),
                    getModel().getGameOverEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
