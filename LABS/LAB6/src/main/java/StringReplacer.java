public class StringReplacer implements StringTransformer {

    private char firstChar;
    private char secondChar;

    public StringReplacer(char x, char y) {
        this.firstChar = x;
        this.secondChar = y;
    }

    @Override
    public void execute(StringDrink drink) {

        String str = drink.getText();
        StringBuilder x = new StringBuilder(str);

        for (int i = 0; i < drink.getText().length(); i++) {

            if (Character.valueOf(str.charAt(i)).equals(firstChar)) {
                x.setCharAt(i, secondChar);
            }
        }
        drink.setText(x.toString());
    }

    public void undo(StringDrink drink) {
        String str = drink.getText();
        StringBuilder x = new StringBuilder(str);

        for (int i = 0; i < drink.getText().length(); i++) {

            if (Character.valueOf(str.charAt(i)).equals(secondChar)) {
                x.setCharAt(i, firstChar);
            }
        }
        drink.setText(x.toString());
    }
}
