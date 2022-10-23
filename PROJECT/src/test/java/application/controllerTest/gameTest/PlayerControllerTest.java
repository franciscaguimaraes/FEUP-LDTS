package application.controllerTest.gameTest;

import application.Game;
import application.controller.game.PlayerController;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Margins;
import application.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private Game game = Mockito.mock(Game.class);
    private PlayerController controller;
    private Player player;
    private BattleField battleField;

    @BeforeEach
    void setUp() {
        battleField = new BattleField(20,25);
        player = new Player(battleField.getWidth()/2,battleField.getHeight()-2);
        battleField.setPlayer(player);

        battleField.setMargins(List.of());
        battleField.setEnemies(List.of());
        battleField.setCovers(List.of());
        battleField.setBombs(List.of());

        controller = new PlayerController(battleField);
    }

    @Test
    void CanPlayerMoveRight(){
    controller.movePlayerRight();
    assertEquals(11,player.getPosition().getX());
    }

    @Test
    void CanPlayerMoveLeft(){
        controller.movePlayerLeft();
        assertEquals(9,player.getPosition().getX());
    }

    @Test
    void MovePlayerIsInsideMargins(){
        controller.movePlayerRight();
        assertEquals(new Position(11,23), player.getPosition());
    }

    @Test
    void movePlayerRightIsNotInsideMargins() {
        battleField.setMargins(List.of(new Margins(20, 25)));
        controller.step(game, GUI.ACT.RIGHT,1000);

        Position expectedPosition = new Position(11,23);
        assertEquals(expectedPosition,player.getPosition());
    }
}
