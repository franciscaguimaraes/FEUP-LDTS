public class StringInverter implements StringTransformer{

    public void execute(StringDrink drink) {
        String str = drink.getText();

        StringBuilder x = new StringBuilder(str);
        x.reverse();
        drink.setText(x.toString());
    }

    public void undo(StringDrink drink) {
       execute(drink);
    }
}
