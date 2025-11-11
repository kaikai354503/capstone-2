import java.util.Scanner;

public class Drink implements Product {
    double price;
    int qty;
    String flavor;
    String size;
    Scanner choice = new Scanner(System.in);

    public Drink(String flavor, String size, double price){
        this.flavor = flavor;
        this.size = size;
    }





    @Override
    public double getPrice() {
        System.out.println("What size would you like? Small | Medium | Large");
        size = choice.nextLine().trim();

        if (size.equalsIgnoreCase("large")){
            price = 3.00;
        }
        if(size.equalsIgnoreCase("medium")){
            price = 2.50;
        }
        if(size.equalsIgnoreCase("small")){
            price = 2.00;
        }

        return price;


    }

    @Override
    public String getDetails() {
        return "";
    }

    @Override
    public String getName() {
        return flavor;
    }

}
