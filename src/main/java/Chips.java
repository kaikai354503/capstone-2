import java.util.Scanner;

public class Chips implements Product {

    String flavor;
    int qty;
    double price = 2.50;

    public Chips(String flavor) {


    }

    public  void getFlavor(String flavor){
        Scanner choice = new Scanner(System.in);
        System.out.println("What kind of chips would you like? BBQ Lays | Cool Ranch Doritos | kettle Cooked Jalepenios");
        flavor = choice.nextLine().trim();
        this.flavor = flavor;
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
        return "";
    }


}
