package application.model.game.elements;

public class Covers extends Element{
    private int dmg;

    public Covers(int x, int y) {
        super(x, y);
        this.dmg = 3;
    }

    public void dmgTaken(){
        this.dmg--;
    }

    public int coverHp(){
        return this.dmg;
    }
}
