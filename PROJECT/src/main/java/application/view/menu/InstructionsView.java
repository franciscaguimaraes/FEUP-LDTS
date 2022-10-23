package application.view.menu;

import application.gui.GUI;
import application.model.Position;
import application.model.menu.Instructions;
import application.view.View;

import java.util.Arrays;
import java.util.List;

public class InstructionsView extends View<Instructions> {
    private final List<String> text;

    public InstructionsView(Instructions instructions) {
        super(instructions);

        this.text = Arrays.asList("SHOOT THE INVADERS"," USING YOUR SHOOT ","COMMAND   (SPACE)",
                "  WHILE AVOIDING  "," THEIR BOMBS TO ","PREVENT LOSING THE","WAR. USE THE ARROW",
                " KEYS   (LEFT) AND ","  (RIGHT) TO MOVE ","  SIDEWAYS! YOU  ","START WITH 3 LIVES",
                " AND IF YOU LOSE  "," ANY YOU MAY GAIN ", "   THEM BACK BY   ", "KILLING HALF (12)",
                "OF YOUR OPPONENTS", "GOOD LUCK SOLDIER!");
    }

    @Override
    public void drawElements(GUI gui) {
        int k = 0;

        for (int i=2; i<19; i++){
            if(i==18){
                gui.drawText(new Position(1, i+2), text.get(k), "#FFFFFF");
            } else {
                gui.drawText(new Position(1, i), text.get(k), "#FFFFFF");
            }
            k++;
        }

        gui.drawSpaceBar(new Position(9,3));
        gui.drawArrowLeft(new Position(7,8));
        gui.drawArrowRight(new Position(2,9));

        gui.drawText(new Position(1, 24), getModel().getEntry(), getModel().isSelected(0) ? "#FFD700" : "#FFFFFF");
    }
}
