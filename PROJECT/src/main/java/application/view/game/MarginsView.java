package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Margins;

public class MarginsView implements ElementView<Margins> {

    @Override
    public void draw(Margins margins, GUI gui) {
        gui.drawMargins(margins.getPosition());
    }

}
