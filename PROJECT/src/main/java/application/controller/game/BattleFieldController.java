package application.controller.game;

import application.Game;
import application.gui.GUI;
import application.model.game.battlefield.BattleField;
import application.model.menu.GameOver;
import application.model.menu.GameWon;
import application.model.menu.Menu;
import application.states.GameOverState;
import application.states.GameWonState;
import application.states.MenuState;

import java.io.IOException;

public class BattleFieldController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;
    private final BulletController bulletController;
    private final BombController bombController;

    public BattleFieldController(BattleField battleField) {
        super(battleField);

        this.playerController = new PlayerController(battleField);
        this.enemyController = new EnemyController(battleField);
        this.bulletController = new BulletController(battleField);
        this.bombController = new BombController(battleField);
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {
        if (action == GUI.ACT.QUIT){
            game.setState(new MenuState(new Menu()));
        } else if (enemyController.enemiesReachedPlayer() || getModel().getPlayer().getLives() == 0) {
            game.setState(new GameOverState(new GameOver()));
        }else if(getModel().getEnemies().size() == 0){
            game.setState(new GameWonState(new GameWon()));
        } else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
            bulletController.step(game, action, time);
            bombController.step(game, action, time);
        }
    }
}
