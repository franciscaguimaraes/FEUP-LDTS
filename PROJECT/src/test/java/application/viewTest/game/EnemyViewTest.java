package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Enemy;
import application.view.game.EnemyView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EnemyViewTest {
    Enemy enemy;
    EnemyView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.enemy = new Enemy(10,23);
        viewer = new EnemyView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkBulletDraw(){
        viewer.draw(enemy,gui);
        Mockito.verify(gui, Mockito.times(1)).drawEnemies(enemy.getPosition());
    }
}
