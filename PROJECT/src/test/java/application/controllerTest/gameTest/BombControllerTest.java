package application.controllerTest.gameTest;

import application.Game;
import application.controller.game.BombController;
import application.gui.GUI;
import application.model.Position;
import application.model.game.battlefield.BattleField;
import application.model.game.elements.Bomb;
import application.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BombControllerTest {
    private BattleField battleField;
    private Game game;
    private BombController bombController;
    GUI gui;


    @BeforeEach
    void setUp() {
        battleField = new BattleField(20,25);

        Player player = new Player(battleField.getWidth() / 2, battleField.getHeight() - 2);
        battleField.setPlayer(player);

        battleField.setMargins(List.of());
        battleField.setEnemies(List.of());
        battleField.setBombs(List.of());
        battleField.setCovers(List.of());


        bombController = new BombController(battleField);

        game = Mockito.mock(Game.class);
    }



    @Test
    void canBombMove() throws IOException{
        Bomb bomb = new Bomb(5,5);
        battleField.setBombs(List.of(bomb));

        bombController.step(game, GUI.ACT.NONE,1000);
        assertNotEquals(new Position(5,5),bomb.getPosition());
    }

}
