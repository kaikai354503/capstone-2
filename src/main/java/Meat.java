@SuppressWarnings("ALL")
public class Meat extends Toppings {
    private boolean extraMeat;
    public Meat(String name, double price) {
        super(name, price);

    }

    @Override
    public boolean isMeat(){
        return true;
    }


}
