package application.controller.game;

import application.Game;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Covers;
import application.model.game.elements.Enemy;
import application.model.game.elements.Margins;

import java.util.Iterator;

public class BulletController extends GameController{
    private long lastMovement;

    public BulletController(BattleField battleField) {
        super(battleField);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACT action, long time){
        if (time - lastMovement > 30){
            if(action == GUI.ACT.SHOOT && isBulletInInitialPosition()){
                moveBullet();
                this.lastMovement = time;
            } else if (!isBulletInInitialPosition()){
                moveBullet();
                this.lastMovement = time;
            } else {
                resetBulletPosition();
            }
        }
    }

    public void moveBullet(){
        getModel().getBullet().getPosition().setY(getModel().getBullet().getPosition().getY()-1);
        bulletHit();
    }

    private void resetBulletPosition(){
        getModel().getBullet().getPosition().setX(getPlayerPosition().getX());
        getModel().getBullet().getPosition().setY(getPlayerPosition().getY() -1);
    }

    public void bulletHit(){
        bulletHitEnemies();
        bulletHitMargins();
        bulletHitCovers();
    }

    private boolean isBulletInInitialPosition(){
        final Position bulletInitialPosition = new Position(getPlayerPosition().getX(),
                getPlayerPosition().getY() -1 );
        final Position bulletActualPos = new Position(getModel().getBullet().getPosition().getX(),
                getModel().getBullet().getPosition().getY());
        return  bulletActualPos.getY() == bulletInitialPosition.getY();
    }

    private Position getPlayerPosition(){
        return new Position(getModel().getPlayer().getPosition().getX(),
                getModel().getPlayer().getPosition().getY());
    }

    private void bulletHitEnemies(){
        Iterator<Enemy> iterator = getModel().getEnemies().iterator();

        while(iterator.hasNext()){
            Enemy current = iterator.next();

            if (current.getPosition().getX() == getModel().getBullet().getPosition().getX() &&
                    current.getPosition().getY() == getModel().getBullet().getPosition().getY()) {

                iterator.remove();

                resetBulletPosition();
                getModel().getPlayer().increasePoints();
            }
        }
    }

    private void bulletHitMargins(){
        for (Margins current : getModel().getMargins()) {
            if (current.getPosition().getX() == getModel().getBullet().getPosition().getX() &&
                    current.getPosition().getY() == getModel().getBullet().getPosition().getY()) {

                resetBulletPosition();
            }
        }
    }

    public void bulletHitCovers(){
        for (Covers current : getModel().getCovers()) {
            if (current.getPosition().getX() == getModel().getBullet().getPosition().getX() &&
                    current.getPosition().getY() == getModel().getBullet().getPosition().getY()) {

                resetBulletPosition();
            }
        }
    }
}
