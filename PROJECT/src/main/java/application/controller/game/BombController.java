package application.controller.game;

import application.Game;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Bomb;
import application.model.game.elements.Covers;
import application.model.game.elements.Enemy;
import application.model.game.elements.Margins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BombController extends GameController {
    private long lastMovement;

    public BombController(BattleField battleField) {
        super(battleField);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {
        if (time - lastMovement > 100) {
            moveBombs();
            this.lastMovement = time;
        }
    }

    public void moveBombs() {
        List<Enemy> auxEnemies = new ArrayList<>(getModel().getEnemies());
        boolean flag = false;

        for (Bomb bomb : getModel().getBombs()) {
            if (bomb.getPosition().getY() < getModel().getHeight() - 1) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < getModel().getBombs().size(); i++) {
                final Position bombPosition = getModel().getBombs().get(i).getPosition();
                bombPosition.setY(bombPosition.getY() + 1);
            }
        } else {
            int n = auxEnemies.size() / 4;

            for (int i = 0; i < n; i++) {
                int randIndex = new Random().nextInt(auxEnemies.size());
                getModel().getBombs().set(i, new Bomb(auxEnemies.get(randIndex).getPosition().getX(),
                        auxEnemies.get(randIndex).getPosition().getY()));
                auxEnemies.remove(randIndex);
            }
        }
        bombHit();
    }

    public void bombHit() {
        bombHitPlayer();
        bombHitMargins();
        bombHitCovers();
    }

    private void resetBomb(Bomb currentBomb) {
        currentBomb.getPosition().setY(getModel().getHeight() + 1);
    }

    private void bombHitPlayer() {
        for (Bomb currentBomb : getModel().getBombs()) {
            if (currentBomb.getPosition().getX() == getModel().getPlayer().getPosition().getX() &&
                    currentBomb.getPosition().getY() == getModel().getPlayer().getPosition().getY()) {

                getModel().getPlayer().decreaseLives();
                resetBomb(currentBomb);
            }
        }
    }

    private void bombHitMargins() {
        for (Margins currentMargin : getModel().getMargins()) {
            for (Bomb currentBomb : getModel().getBombs()) {
                if (currentMargin.getPosition().getX() == currentBomb.getPosition().getX() &&
                        currentMargin.getPosition().getY() == currentBomb.getPosition().getY()) {

                    resetBomb(currentBomb);
                }
            }
        }
    }

    private void bombHitCovers() {
        Covers removable = null;
        for (Bomb currentBomb : getModel().getBombs()) {
            for (Covers currentCover : getModel().getCovers()) {
                if (currentCover.getPosition().getX() == currentBomb.getPosition().getX() &&
                        currentCover.getPosition().getY() == currentBomb.getPosition().getY()) {

                    currentCover.dmgTaken();
                    removable = currentCover;
                    resetBomb(currentBomb);
                }
            }
            if(removable != null && removable.coverHp() == 0)
                getModel().getCovers().remove(removable);}
        }
    }


