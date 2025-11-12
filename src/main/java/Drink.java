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
        this.price = price;
    }





    @Override
    public double getPrice() {
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
