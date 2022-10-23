package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Bomb;
import application.view.game.BombView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BombViewTest {
    Bomb bomb;
    BombView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.bomb = new Bomb(10,23);
        viewer = new BombView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkBombDraw(){
        viewer.draw(bomb,gui);
        Mockito.verify(gui, Mockito.times(1)).drawBombs(bomb.getPosition());
    }
}
