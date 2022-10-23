package application.states;

import application.Game;
import application.controller.Controller;
import application.gui.GUI;
import application.view.View;

import java.io.IOException;

public abstract class State<Type> {
    private final Type model;
    private final Controller<Type> controller;
    private final View<Type> view;

    public State(Type model) {
        this.model = model;
        this.view = getViewer();
        this.controller = getController();
    }

    protected abstract View<Type> getViewer();

    protected abstract Controller<Type> getController();

    public Type getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACT action = gui.getNextAction();
        controller.step(game, action, time);
        view.draw(gui);
    }
}
