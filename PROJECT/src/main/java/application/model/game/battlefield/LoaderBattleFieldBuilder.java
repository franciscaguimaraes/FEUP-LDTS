package application.model.game.battlefield;

import application.model.game.elements.*;
import java.util.ArrayList;
import java.util.List;

public class LoaderBattleFieldBuilder extends BattleFieldBuilder {

    public LoaderBattleFieldBuilder() {
        super();
    }
    @Override
    protected int getWidth() {
        return this.width;
    }

    @Override
    protected int getHeight() {
        return this.height;
    }

    @Override
    protected List<Margins> createMargins() {
        List<Margins> margins = new ArrayList<>();

        for(int c=0; c < getWidth(); c++){
            margins.add(new Margins(c, 0));
            margins.add(new Margins(c, getHeight()-1));
        }

        for(int r=0; r < getHeight(); r++){
            margins.add(new Margins(0, r));
            margins.add(new Margins(getWidth()-1, r));
        }

        return margins;
    }

    @Override
    protected List<Enemy> createEnemies(int columns, int rows) {
        List<Enemy> enemies = new ArrayList<>();

        for(int i=1; i<=columns; i++){ // columns
            for(int k=1; k<=rows; k++){ // rows

                Enemy newEnemy = new Enemy(i,k);
                enemies.add(newEnemy);
            }
        }
        return enemies;
    }

    @Override
    protected Player createPlayer() {
        return new Player(getWidth() / 2, getHeight()-2);
    }

    @Override
    protected Bullet createBullet() {
        return new Bullet(createPlayer().getPosition().getX(), createPlayer().getPosition().getY()-1);
    }

    @Override
    protected List<Bomb> createBombs(int columns, int rows){
        List<Bomb> bombs = new ArrayList<>();

        for(int i=1; i<=columns; i++){ // columns
            for(int k=1; k<=rows; k++){ // rows

                Bomb newBomb = new Bomb(i,k+30);
                bombs.add(newBomb);
            }
        }

        return bombs;
    }

    @Override
    protected List <Covers> createCovers(){
        List <Covers> covers = new ArrayList<>();


        for(int c=1; c < getWidth()-1; c++){
            if(c%5 == 0){
                if(c%10 == 0){
                    covers.add(new Covers(c-1, getHeight()-4));
                    covers.add(new Covers(c, getHeight()-4));
                    continue;
                }
                covers.add(new Covers(c-2, getHeight()-4));
                covers.add(new Covers(c-1, getHeight()-4));
                covers.add(new Covers(c, getHeight()-4));
                covers.add(new Covers(c+1, getHeight()-4));
            }
        }
        return covers;
    }
}
