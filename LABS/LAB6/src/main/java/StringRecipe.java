import java.util.List;

public class StringRecipe implements StringTransformer {
    List<StringTransformer> transformers;

    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers=transformers;
    }

    public void mix(StringDrink drink) {
        for (int i = 0; i < transformers.size(); i++) {
            transformers.get(i).execute(drink);
        }
    }

    @Override
    public void execute(StringDrink drink) {

    }
}
