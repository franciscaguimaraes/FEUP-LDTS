package application.modelTest.game.elements;

import application.model.game.elements.Covers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoversTest {
    private Covers covers;

    @BeforeEach
    public void setUp(){
        covers = new Covers(10,10);
    }

    @Test
    public void getDamage(){
        int damage = covers.coverHp();
        assertEquals(3,damage);
    }

    @Test
    public void decreaseDamage(){
        int previousDamage = covers.coverHp();
        covers.dmgTaken();
        assertEquals(previousDamage-1,covers.coverHp());
    }
}
