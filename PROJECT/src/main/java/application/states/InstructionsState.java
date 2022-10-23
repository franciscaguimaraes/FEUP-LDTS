package application.states;

import application.controller.Controller;
import application.controller.menu.InstructionsController;
import application.model.menu.Instructions;
import application.view.View;
import application.view.menu.InstructionsView;

public class InstructionsState extends State<Instructions> {

    public InstructionsState(Instructions model){
        super(model);
    }
    @Override
    protected View<Instructions> getViewer() {
        return new InstructionsView(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}
