package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Player;

public class PlayerView implements ElementView <Player>{

    @Override
    public void draw(Player player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}
