package application.controller;

import application.gui.GUI;

import application.Game;

import java.io.IOException;

public abstract class Controller<Type> {
    private final Type model;

    public Controller(Type model) {
        this.model = model;
    }

    public Type getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACT action, long time) throws IOException;
}