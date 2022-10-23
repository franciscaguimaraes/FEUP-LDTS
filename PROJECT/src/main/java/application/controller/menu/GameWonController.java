package application.controller.menu;

import application.Game;
import application.controller.Controller;
import application.gui.GUI;
import application.model.game.battlefield.LoaderBattleFieldBuilder;
import application.model.menu.GameWon;
import application.states.GameState;


import java.io.IOException;

public class GameWonController extends Controller <GameWon> {

    public GameWonController(GameWon model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {
        switch (action) {
            case UP : getModel().previousGameWonEntry();
                break;
            case DOWN : getModel().nextGameWonEntry();
                break;
            case SELECT : {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedPlayAgain()) {
                    game.setState(new GameState(new LoaderBattleFieldBuilder().withBullet().withPlayer().withEnemies()
                            .withMargins().withBombs().withCovers().build()));
                }
            }
            break;
            default :   // fall out
        }
    }
}
