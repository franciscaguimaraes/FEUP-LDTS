package application.viewTest.game;

import application.gui.GUI;
import application.model.game.elements.Margins;
import application.view.game.MarginsView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MarginsViewTest {
    Margins margins;
    MarginsView viewer;
    GUI gui;

    @BeforeEach
    void setUp() {
        this.margins = new Margins(10,23);
        viewer = new MarginsView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkBulletDraw(){
        viewer.draw(margins,gui);
        Mockito.verify(gui, Mockito.times(1)).drawMargins(margins.getPosition());
    }
}
