package application.states;

import application.controller.Controller;
import application.controller.game.BattleFieldController;
import application.model.game.battlefield.BattleField;
import application.view.View;
import application.view.game.GameView;

public class GameState extends State<BattleField> {
    public GameState(BattleField battleField) {
        super(battleField);
    }

    @Override
    protected View<BattleField> getViewer() {
        return new GameView(getModel());
    }

    @Override
    protected Controller<BattleField> getController() {
        return new BattleFieldController(getModel());
    }
}
