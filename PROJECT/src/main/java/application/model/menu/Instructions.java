package application.model.menu;


public class Instructions {

    private final String entries;

    private int currentEntry = 0;

    public Instructions() {
        this.entries = "BACK";
    }

    public String getEntry() {
        return entries;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedBack() { return isSelected(0);}


}
