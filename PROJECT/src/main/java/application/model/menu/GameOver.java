package application.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {

    private final List<String> gameOverEntries;
    private int currentGameOverEntry = 0;

    public GameOver() {
        this.gameOverEntries = Arrays.asList("PLAY AGAIN", "EXIT");
    }


    public void nextGameOverEntry() {
        currentGameOverEntry++;
        if (currentGameOverEntry > this.gameOverEntries.size() - 1)
            currentGameOverEntry = 0;
    }

    public void previousGameOverEntry() {
        currentGameOverEntry--;
        if (currentGameOverEntry < 0)
            currentGameOverEntry = this.gameOverEntries.size() - 1;
    }

    public String getGameOverEntry(int i) {
        return gameOverEntries.get(i);
    }

    public boolean isSelected(int i) {
        return currentGameOverEntry == i;
    }

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.gameOverEntries.size();
    }

}
