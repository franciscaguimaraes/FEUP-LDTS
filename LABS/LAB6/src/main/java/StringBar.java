public class StringBar extends Bar{

    public StringBar() {
        super(false);
    }


    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
