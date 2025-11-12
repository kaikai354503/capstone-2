import java.util.Scanner;

public class Chips implements Product {

    String flavor;
    int qty;
    double price = 2.50;

    public Chips(String flavor, double price) {


    }




    @Override
    public double getPrice() {
        return price;
    }



    @Override
    public String getName() {
        return flavor;
    }


}
