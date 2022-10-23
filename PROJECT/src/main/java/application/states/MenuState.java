package application.states;

import application.controller.Controller;
import application.controller.menu.MenuController;
import application.model.menu.Menu;
import application.view.View;
import application.view.menu.MenuView;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected View<Menu> getViewer() {
        return new MenuView(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

}
