package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Bullet;
import application.view.game.BulletView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BulletViewTest {

    Bullet bullet;
    BulletView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.bullet = new Bullet(10,23);
        viewer = new BulletView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkBulletDraw(){
        viewer.draw(bullet,gui);
        Mockito.verify(gui, Mockito.times(1)).drawBullet(bullet.getPosition());
    }

}
