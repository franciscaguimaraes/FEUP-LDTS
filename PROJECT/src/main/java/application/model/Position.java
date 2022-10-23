package application.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public int getX() { return x;}

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Position)) return false;

        return (this == o) || (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
