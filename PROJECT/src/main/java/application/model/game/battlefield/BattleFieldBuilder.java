package application.model.game.battlefield;

import application.model.game.elements.*;

import java.util.List;

public abstract class BattleFieldBuilder {

    protected int width;
    protected int height;
    protected Player player;
    protected Bullet bullet;
    protected List<Enemy> enemies;
    protected List<Margins> margins;
    protected List <Bomb> bombs;
    protected List <Covers> covers;

    public BattleFieldBuilder() {
        this.width = 20;
        this.height = 25;
    }

    public BattleFieldBuilder withPlayer() {
        this.player = createPlayer();
        return this;
    }

    public BattleFieldBuilder withBullet() {
        this.bullet = createBullet();
        return this;
    }

    public BattleFieldBuilder withEnemies() {
        this.enemies = createEnemies(8,3);
        return this;
    }

    public BattleFieldBuilder withMargins() {
        this.margins = createMargins();
        return this;
    }

    public BattleFieldBuilder withBombs() {
        this.bombs = createBombs(8, 3);
        return this;
    }

    public BattleFieldBuilder withCovers() {
        this.covers = createCovers();
        return this;
    }

    public BattleField build() {
        BattleField battleField = new BattleField(getWidth(), getHeight());

        battleField.setBullet(this.bullet);
        battleField.setPlayer(this.player);
        battleField.setEnemies(this.enemies);
        battleField.setMargins(this.margins);
        battleField.setBombs(this.bombs);
        battleField.setCovers(this.covers);

        return battleField;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<Margins> createMargins();
    protected abstract List<Enemy> createEnemies(int columns, int rows);
    protected abstract Player createPlayer();
    protected abstract Bullet createBullet();
    protected abstract List<Bomb> createBombs(int columns, int rows);
    protected abstract List<Covers> createCovers();
}
