import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    Boolean order = false;
    List<StringDrink> Drinks = new ArrayList<>();
    List<StringRecipe> Recipes = new ArrayList<>();


    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

        if(bar.isHappyHour()){
            bar.order(drink, recipe);
        } else {
            this.Drinks.add(drink);
            this.Recipes.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        while(!Drinks.isEmpty()){
            wants(Drinks.get(0), Recipes.get(0), bar);
            Drinks.remove(0);
            Recipes.remove(0);
        }

    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
