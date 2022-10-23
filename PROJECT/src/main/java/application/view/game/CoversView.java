package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Covers;

public class CoversView implements ElementView <Covers> {

    @Override
    public void draw(Covers covers, GUI gui) {
        gui.drawCovers(covers.getPosition());
    }
}
