public class StringCaseChanger implements StringTransformer{

    public void execute(StringDrink drink) {

        String str = drink.getText();

        StringBuilder x = new StringBuilder(str);

        for (int i = 0; i < drink.getText().length(); i++) {
            if(Character.isLowerCase(str.charAt(i))){
                 x.setCharAt(i,Character.toUpperCase(str.charAt(i)));
            } else if (Character.isUpperCase(str.charAt(i))) {
                x.setCharAt(i,Character.toLowerCase(str.charAt(i)));
            }
        }

        drink.setText(x.toString());
    }

    public void undo(StringDrink drink) {
        execute(drink);
    }
}
