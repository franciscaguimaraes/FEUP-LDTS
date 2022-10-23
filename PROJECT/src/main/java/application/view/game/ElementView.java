package application.view.game;

import application.gui.GUI;
import application.model.game.elements.Element;

public interface ElementView<T extends Element> {
    void draw(T element, GUI gui);
}
