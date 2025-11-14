public class Cheese extends Toppings {
    public Cheese(String name, double price) {
        super(name, price);
    }

    @Override
    public boolean isCheese(){
        return true;
    }
}
