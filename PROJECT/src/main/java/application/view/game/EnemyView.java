package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Enemy;

public class EnemyView implements ElementView <Enemy> {

    @Override
    public void draw(Enemy enemy, GUI gui) {
        gui.drawEnemies(enemy.getPosition());
    }

}
