package application.controllerTest.gameTest;

import application.Game;
import application.controller.game.EnemyController;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Enemy;
import application.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemyControllerTest {
    private Game game;
    private EnemyController controller ;
    private BattleField battleField;

    @BeforeEach
    void setUp() {
        battleField = new BattleField (20,25);

        Player player = new Player(battleField.getWidth() / 2, battleField.getHeight() - 2);
        battleField.setPlayer(player);

        battleField.setMargins(List.of());
        battleField.setEnemies(List.of());
        battleField.setBombs(List.of());
        battleField.setCovers(List.of());


        controller = new EnemyController(battleField);

        game = Mockito.mock(Game.class);
    }


    @Test
    void stepTest() throws IOException {
        controller.step(game, GUI.ACT.NONE,1);
        assertEquals(1,controller.canEnemiesMove());
    }

    @Test
    void moveEnemy() throws IOException {
    Enemy enemy = new Enemy(5,5);
    battleField.setEnemies(List.of(enemy));

    controller.step(game,GUI.ACT.NONE,1000);
    assertNotEquals(new Position(5,5),enemy.getPosition());
    }

    @Test
    void canEnemiesMoveVertically(){

    }


    @Test
    void doEnemiesReachPlayers(){

    }
}
