import java.util.Scanner;

public class Drink implements Product {
    double price;
    String flavor;
    String size;
    Scanner choice = new Scanner(System.in);

    public Drink(String flavor, String size){

    }

    public void getDrink(String flavor, String size){


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


        System.out.println("What drink would you like? Water | Soda ");
        flavor = choice.nextLine().trim();

        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double getPrice() {

        return price;
    }
}
