package application.model.game.elements;

public class Player extends Element {
    private int lives;
    private int points;

    public Player(int x, int y) {
        super(x, y);
        this.lives = 3;
        this.points = 0;
    }

    public void decreaseLives() {
        this.lives--;
    }

    public int getLives() {
        return lives;
    }

    public void increasePoints(){
        this.points ++;
        if (points == 12){
            points = 0;
            lives ++;
        }
    }

    public int getPoints(){ return points;}
}

