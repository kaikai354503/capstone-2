import java.util.Scanner;

public class Drink implements Product {
    double price;

    String flavor;
    String size;



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

    @Override
    public boolean isSandwich() {
        return false;
    }

}
