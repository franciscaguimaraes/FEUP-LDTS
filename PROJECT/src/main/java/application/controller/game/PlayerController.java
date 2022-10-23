package application.controller.game;

import application.Game;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;

public class PlayerController extends GameController {
    public PlayerController(BattleField battleField) {super(battleField);
    }

    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    private void movePlayer(Position position) {
        if (getModel().isInsideMargins(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isBomb(position)) getModel().getPlayer().decreaseLives();
        }
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) {
        if (action == GUI.ACT.RIGHT) movePlayerRight();
        if (action == GUI.ACT.LEFT) movePlayerLeft();
    }
}
