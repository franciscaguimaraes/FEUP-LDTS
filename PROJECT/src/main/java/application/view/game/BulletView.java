package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Bullet;

public class BulletView implements ElementView <Bullet> {

    @Override
    public void draw(Bullet bullet, GUI gui) {
        gui.drawBullet(bullet.getPosition());
    }

}
