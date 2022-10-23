package application.controllerTest.gameTest;

import application.Game;
import application.controller.game.BulletController;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Bullet;
import application.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BulletControllerTest {
    private Game game;
    private BulletController controller ;
    private BattleField battleField;
    private Player player;

    @BeforeEach
    void setUp() {
        battleField = new BattleField(20,25);

        player = new Player(battleField.getWidth()/2, battleField.getHeight()-2);
        battleField.setPlayer(player);

        battleField.setMargins(List.of());
        battleField.setEnemies(List.of());
        battleField.setBombs(List.of());
        battleField.setCovers(List.of());


        controller = new BulletController(battleField);

        game = Mockito.mock(Game.class);
    }

    @Test
    void canBulletMove(){
        Bullet bullet = new Bullet(5,5);
        battleField.setBullet(bullet);

        controller.step(game, GUI.ACT.NONE,1000);
        assertNotEquals(new Position(5,5),bullet.getPosition());
    }

}
