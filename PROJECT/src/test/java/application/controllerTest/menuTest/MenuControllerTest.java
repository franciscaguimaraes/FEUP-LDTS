package application.controllerTest.menuTest;

import application.Game;
import application.controller.menu.MenuController;
import application.gui.GUI;
import application.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {

    MenuController mc;
    Menu menu;
    Game game;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        menu = new Menu();
        mc = new MenuController(menu);
    }

    @Test
    void TestDown() throws IOException{
        mc.step(game, GUI.ACT.DOWN,0);

        menu.nextEntry();
        Assertions.assertEquals(menu,mc.getModel());
    }

    @Test
    void TestUp() throws IOException{
        mc.step(game, GUI.ACT.UP,0);

        menu.previousEntry();
        Assertions.assertEquals(menu,mc.getModel());
    }

    @Test
    void TestSelect() throws IOException{
        mc.step(game, GUI.ACT.SELECT,0);

        menu.isSelectedExit();
        Assertions.assertEquals(menu,mc.getModel());
    }
}
