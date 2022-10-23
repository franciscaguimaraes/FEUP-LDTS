package application.modelTest;

import application.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private final int x = 10;
    private final int y = 10;

    @Test
    public void getLeft() {
        Assertions.assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Test
    public void getRight() {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Test
    public void testEquals_Symmetric() {
        Position position1 = new Position(x,y);
        Position position2 = new Position(10,10);
        assertEquals(position1.equals(position2),position2.equals(position1));
        assertEquals(position1.hashCode(),position2.hashCode());
    }
}