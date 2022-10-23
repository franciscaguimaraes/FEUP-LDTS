package application.view;

import application.gui.GUI;

import java.io.IOException;

public abstract class View<Type> {
    private final Type model;

    public View(Type model) {
        this.model = model;
    }

    public Type getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
