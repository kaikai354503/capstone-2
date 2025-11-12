import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich implements Product{
    double price;
    private String size;
    private Bread bread;

    private ArrayList<Toppings> toppings = new ArrayList<>();

    public Sandwich (String size, Bread bread, double price){
        this.size = size;
        this.bread = bread;
        this.price = price;
    }


    public static void getSize(){
        System.out.println("What size sandwich would you like?");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        Scanner scanner = new Scanner(System.in);
        size = scanner.nextLine().trim();
        switch (size){
            case"1":
                size = "small";
                break;
            case "2":
                size = "medium";
                break;
            case "3":
                size = "large";
                break;
            default:
                System.out.println("not a valid option try again.");
        }
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double total = bread.getPrice();
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
