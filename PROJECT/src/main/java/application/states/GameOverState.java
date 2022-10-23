package application.states;

import application.controller.Controller;
import application.controller.menu.GameOverController;
import application.model.menu.GameOver;
import application.view.View;
import application.view.menu.GameOverView;

public class GameOverState extends State<GameOver> {

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected View<GameOver> getViewer() {
        return new GameOverView(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
