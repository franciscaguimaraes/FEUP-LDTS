package application.modelTest.game.elements;

import application.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp(){
        player = new Player(10,10);
    }

    @Test
    public void getPoints(){
        int points = player.getPoints();
        assertEquals(0,points);
    }

    @Test
    public void decreaseLives(){
        int previousLives = player.getLives();
        player.decreaseLives();
        assertEquals(previousLives-1,player.getLives());
    }

    @Test
    public void increasePoints(){
        int previousPoints = player.getPoints();
        int previousLives = player.getLives();
        for(int i=0; i<12;i++){
            player.increasePoints();
        }

        assertEquals(previousPoints, player.getPoints());
        assertEquals(previousLives + 1, player.getLives());
    }
}

