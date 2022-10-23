package application.states;

import application.controller.Controller;
import application.controller.menu.GameWonController;
import application.model.menu.GameWon;
import application.view.View;
import application.view.menu.GameWonView;

public class GameWonState extends State<GameWon> {

    public GameWonState(GameWon model) {
        super(model);
    }

    @Override
    protected View<GameWon> getViewer() {
        return new GameWonView(getModel());
    }

    @Override
    protected Controller<GameWon> getController() {
        return new GameWonController(getModel());
    }
}
