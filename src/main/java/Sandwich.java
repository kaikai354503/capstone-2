import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich implements Product{
    private double basePrice;
    private String size;
    private Bread bread;
    boolean toasted;

    private ArrayList<Toppings> toppings = new ArrayList<>();

    public Sandwich (String size, Bread bread, double basePrice){
        this.size = size;
        this.bread = bread;
        this.basePrice = basePrice;
    }


    public void addTopping(Toppings topping){
        toppings.add(topping);
    }

    public  ArrayList<Toppings> getToppings(){
        return toppings;
    }

    public boolean isSandwich(){
        return true;
    }

    public String toString(){
        String mainMeat = "Veggie";

               for(Toppings t : toppings) {
                   if (t.isMeat()) {
                       mainMeat = t.getName();
                       break;
                   }
               }

               return String.format("%s %s sandwich on %s bread | $%.2f",
                       size,
                       mainMeat,
                       bread.toString(),
                       getPrice());
    }

    public boolean askToasted(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like this sandwich toasted? Y/N");
        String choice = scanner.nextLine().trim().toUpperCase();
        if(choice.toUpperCase().equals("Y")){
            toasted = true;
        }
        else
            toasted = false;
        return toasted;
    }

    public boolean isToasted(){
        return toasted;
    }

    @Override
    public double getPrice() {
        double total = basePrice;
        for(Toppings t : toppings){
            total += t.getPrice();
        }
        return total;
    }

    @Override
    public String getName() {
        return size + " Sandwich on " + bread;
    }
}
