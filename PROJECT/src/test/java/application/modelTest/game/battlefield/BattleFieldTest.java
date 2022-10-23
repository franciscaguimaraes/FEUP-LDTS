package application.modelTest.game.battlefield;

import application.model.game.battlefield.BattleField;
import application.model.game.battlefield.LoaderBattleFieldBuilder;
import application.model.game.elements.Bomb;
import application.model.game.elements.Margins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleFieldTest {

    private BattleField b;

    @BeforeEach
    public void setUp() {
        this.b = new LoaderBattleFieldBuilder()
                .withBullet()
                .withPlayer()
                .withEnemies()
                .withMargins()
                .withBombs()
                .withCovers()
                .build();
    }

    @Test
    public void checkWallsSize(){
        assertEquals(90, b.getMargins().size());
    }

    @Test
    public void checkEnemiesSize(){
        assertEquals(24, b.getEnemies().size());
    }

    @Test
    public void checkCoversSize(){
        assertEquals(10, b.getCovers().size());
    }

    @Test
    public void checkPlayerPosition(){
        assertEquals(b.getWidth()/2, b.getPlayer().getPosition().getX());
        assertEquals(b.getHeight()-2, b.getPlayer().getPosition().getY());
    }

    @Test
    public void checkBulletInitialPosition(){
        assertEquals(b.getWidth()/2, b.getBullet().getPosition().getX());
        assertEquals(b.getHeight()-3, b.getBullet().getPosition().getY());
    }

    @Test
    public void checkBombsSize(){
        assertEquals(24, b.getBombs().size());
    }

    @Test
    public void checkBombCollision(){
        b.getBombs().add(new Bomb(1,1));
        Bomb bomb = new Bomb(1,1);

        assertTrue(b.isBomb(bomb.getPosition()));
    }

    @Test
    public void checkMarginsCollision(){
        b.getMargins().add(new Margins(1,1));
        Margins margins = new Margins(1,1);

        assertFalse(b.isInsideMargins(margins.getPosition()));
    }

}
