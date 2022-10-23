package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Bomb;

public class BombView implements ElementView<Bomb>{

    @Override
    public void draw(Bomb bomb, GUI gui) {
        gui.drawBombs(bomb.getPosition());
    }

}
