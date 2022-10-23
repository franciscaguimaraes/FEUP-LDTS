package application.controller.game;

import application.controller.Controller;
import application.model.game.battlefield.BattleField;

public abstract class GameController extends Controller<BattleField> {
    public GameController(BattleField battleField) {
        super(battleField);
    }
}
