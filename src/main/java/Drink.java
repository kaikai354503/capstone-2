import java.util.Scanner;

public class Drink implements Product {
    double price;
    int qty;
    String flavor;
    String size;
    String name = flavor;


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
    public String getName() {
        return size + " " + flavor;
    }

}
