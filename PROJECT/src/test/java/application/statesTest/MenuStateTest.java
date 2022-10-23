package application.statesTest;

import application.model.menu.Menu;
import application.states.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MenuStateTest {
    private MenuState menuState;
    private Menu transition;

    @BeforeEach
    void setUp(){
        transition = new Menu();
        menuState = new MenuState(transition);
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,menuState.getModel());
    }

}
