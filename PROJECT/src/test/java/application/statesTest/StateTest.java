package application.statesTest;

import application.controller.Controller;
import application.model.menu.GameOver;
import application.model.menu.GameWon;
import application.model.menu.Instructions;
import application.model.menu.Menu;
import application.states.State;
import application.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {

    @Test
    public void checkMenuState(){
        Menu menu = new Menu();
        State<Menu> stateMenu = new State<>(menu){
            @Override
            protected View<Menu> getViewer() {
                return null;
            }

            @Override
            protected Controller<Menu> getController() {
                return null;
            }
        };
        assertEquals(menu, stateMenu.getModel());
    }

    @Test
    public void checkInstructionsState(){
        Instructions instructions = new Instructions();
        State<Instructions> stateMenu = new State<>(instructions){
            @Override
            protected View<Instructions> getViewer() {
                return null;
            }

            @Override
            protected Controller<Instructions> getController() {
                return null;
            }
        };
        assertEquals(instructions, stateMenu.getModel());
    }

    @Test
    public void checkGameWonState(){
        GameWon gameWon = new GameWon();
        State<GameWon> stateMenu = new State<>(gameWon){
            @Override
            protected View<GameWon> getViewer() {
                return null;
            }

            @Override
            protected Controller<GameWon> getController() {
                return null;
            }
        };
        assertEquals(gameWon, stateMenu.getModel());
    }

    @Test
    public void checkGameOverState(){
        GameOver gameOver = new GameOver();
        State<GameOver> stateMenu = new State<>(gameOver){
            @Override
            protected View<GameOver> getViewer() {
                return null;
            }

            @Override
            protected Controller<GameOver> getController() {
                return null;
            }
        };
        assertEquals(gameOver, stateMenu.getModel());
    }
}
