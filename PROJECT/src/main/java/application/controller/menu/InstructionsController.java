package application.controller.menu;

import application.Game;
import application.controller.Controller;
import application.gui.GUI;
import application.model.menu.Instructions;
import application.model.menu.Menu;
import application.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions> {

    public InstructionsController(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void step(Game game, GUI.ACT action, long time) throws IOException {

        if(action == GUI.ACT.SELECT && getModel().isSelectedBack()){
            game.setState(new MenuState(new Menu()));
        }
    }
}
