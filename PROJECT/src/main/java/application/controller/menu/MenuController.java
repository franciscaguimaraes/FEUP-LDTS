package application.controller.menu;

import application.Game;
import application.controller.Controller;
import application.gui.GUI;
import application.model.game.battlefield.LoaderBattleFieldBuilder;
import application.model.menu.Instructions;
import application.model.menu.Menu;
import application.states.GameState;
import application.states.InstructionsState;


import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {
        switch (action) {
            case UP : getModel().previousEntry();
                break;
            case DOWN : getModel().nextEntry();
                break;
            case SELECT : {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) {
                    game.setState(new GameState(new LoaderBattleFieldBuilder().withBullet().withPlayer().withEnemies()
                            .withMargins().withBombs().withCovers().build()));

                }
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Instructions()));
            }
            break;
            default :  // fall out

        }
    }
}