package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Player;
import application.view.game.PlayerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerViewTest {

    Player player;
    PlayerView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.player = new Player(10,23);
        viewer = new PlayerView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkPlayerDraw(){
        viewer.draw(player,gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player.getPosition());
    }
}
