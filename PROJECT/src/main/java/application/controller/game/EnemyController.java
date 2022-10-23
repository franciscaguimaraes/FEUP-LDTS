package application.controller.game;

import application.Game;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Enemy;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;
    private int moveDirection = 2;

    public EnemyController(BattleField battleField) {
        super(battleField);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {
        if (time - lastMovement > 600) {
            moveEnemy();
            this.lastMovement = time;
        }
    }

    private void moveEnemy() {
        int moveDirection = canEnemiesMove();

        if (moveDirection == 0) {
            moveEnemiesVertically();
        } else {
            moveEnemiesHorizontally(moveDirection);
        }
    }

    public int canEnemiesMove(){
        Position leftEnemyPos = new Position(9999, 1);
        Position rightEnemyPos = new Position(0, 1);

        for(Enemy enemy : getModel().getEnemies()){
            if (enemy.getPosition().getX() > rightEnemyPos.getX()){
                rightEnemyPos.setX(enemy.getPosition().getX());
                rightEnemyPos.setY(enemy.getPosition().getY());
            }
            if (enemy.getPosition().getX() < leftEnemyPos.getX()){
                leftEnemyPos.setX(enemy.getPosition().getX());
                leftEnemyPos.setY(enemy.getPosition().getY());
            }
        }

        if(moveDirection != -1 && getModel().isInsideMargins(new Position(rightEnemyPos.getX()+1, rightEnemyPos.getY()))){
            moveDirection = 1;
        } else if(moveDirection != 1 && getModel().isInsideMargins(new Position(leftEnemyPos.getX()-1, leftEnemyPos.getY()))){
            moveDirection = -1;
        } else {
            moveDirection = 0;
        }

        return moveDirection;
    }

    public void moveEnemiesVertically(){
        for(Enemy enemy : getModel().getEnemies()){
            enemy.setPosition(new Position(enemy.getPosition().getX(), enemy.getPosition().getY()+1));
        }
    }

    public void moveEnemiesHorizontally(int offSet){
        for(Enemy enemy : getModel().getEnemies()){
            enemy.setPosition(new Position(enemy.getPosition().getX()+offSet, enemy.getPosition().getY()));
        }
    }

    public boolean enemiesReachedPlayer() {
        Position downEnemyPos = new Position(0, 0);

        for (Enemy enemy : getModel().getEnemies()) {
            if (enemy.getPosition().getY() > downEnemyPos.getY()) {
                downEnemyPos.setY(enemy.getPosition().getY());
            }
        }

        return downEnemyPos.getY() == getModel().getPlayer().getPosition().getY() - 2;
    }
}
