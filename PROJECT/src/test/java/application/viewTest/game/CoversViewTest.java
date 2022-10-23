package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Covers;
import application.view.game.CoversView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CoversViewTest {
    Covers covers;
    CoversView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.covers = new Covers(10,23);
        viewer = new CoversView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkCoversDraw(){
        viewer.draw(covers,gui);
        Mockito.verify(gui, Mockito.times(1)).drawCovers(covers.getPosition());
    }
}
