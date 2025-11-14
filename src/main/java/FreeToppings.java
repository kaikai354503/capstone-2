@SuppressWarnings("ALL")
public class FreeToppings extends Toppings {
    public FreeToppings(String name, double price) {
        super(name, 0.0);
    }

    @Override
    public boolean isFreeTopping(){
        return true;
    }
}
