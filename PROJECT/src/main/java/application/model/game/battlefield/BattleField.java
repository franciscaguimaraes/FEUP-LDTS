package application.model.game.battlefield;

import application.model.Position;
import application.model.game.elements.*;

import java.util.List;

public class BattleField {
    private final int width;
    private final int height;
    private Player player;
    private Bullet bullet;
    private List<Enemy> enemies;
    private List<Margins> margins;
    private List <Bomb> bombs;
    private List <Covers> covers;

    public BattleField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public Bullet getBullet() { return bullet;}

    public void setBullet(Bullet bullet){ this.bullet = bullet; }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Margins> getMargins() {
        return margins;
    }

    public void setMargins(List<Margins> margins) {
        this.margins = margins;
    }

    public List<Bomb> getBombs() { return bombs; }

    public void setBombs(List<Bomb> bombs) { this.bombs = bombs; }

    public List<Covers> getCovers() {
        return covers;
    }

    public void setCovers(List<Covers> covers) {
        this.covers = covers;
    }

    public boolean isInsideMargins(Position position) {
        for (Margins margins : this.margins)
            if (margins.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isBomb(Position position) {
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position))
                return true;
        return false;
    }
}
