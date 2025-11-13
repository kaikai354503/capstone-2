import java.util.ArrayList;

public class Sandwich implements Product{
    private double basePrice;
    private String size;
    private Bread bread;

    private ArrayList<Topping> toppings = new ArrayList<>();

    public Sandwich (String size, Bread bread, double basePrice){
        this.size = size;
        this.bread = bread;
        this.basePrice = basePrice;
    }


    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public  ArrayList<Topping> getToppings(){
        return toppings;
    }

    @Override
    public double getPrice() {
        double total = basePrice;
        for(Topping t : toppings){
            total += t.getPrice();
        }
        return total;
    }

    @Override
    public String getName() {
        return size + " Sandwich on " + bread;
    }
}
