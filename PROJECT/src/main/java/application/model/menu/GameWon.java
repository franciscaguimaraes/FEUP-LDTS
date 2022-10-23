package application.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameWon {

    private final List<String> gameWonEntries;
    private int currentGameWonEntry = 0;

    public GameWon() {
        this.gameWonEntries = Arrays.asList("PLAY AGAIN", "EXIT");
    }


    public void nextGameWonEntry() {
        currentGameWonEntry++;
        if (currentGameWonEntry > this.gameWonEntries.size() - 1)
            currentGameWonEntry = 0;
    }

    public void previousGameWonEntry() {
        currentGameWonEntry--;
        if (currentGameWonEntry < 0)
            currentGameWonEntry = this.gameWonEntries.size() - 1;
    }

    public String getEntry(int i) {
        return gameWonEntries.get(i);
    }

    public boolean isSelected(int i) {
        return currentGameWonEntry == i;
    }

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.gameWonEntries.size();
    }

}
