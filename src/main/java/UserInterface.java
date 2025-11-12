import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner  scanner = new Scanner(System.in);
    private String size;
    private double price;

    private void start(){
        currentOrder = new Order();
        boolean ordering = true;
    }

    public void displayOrder(){

    }

    public void processNewOrder(){

    }

    public void processAddProduct(){

    }

    private void addDrink(){
        System.out.println("what drink would you like? water | soda ");
        String flavor = scanner.nextLine().trim();

        System.out.println("What size would you like? Small | Medium | Large");
        size = scanner.nextLine().trim();
        if(flavor.toLowerCase().equals("water")){
            price = 0.00;
        }
        if (size.equalsIgnoreCase("large")){
            price = 3.00;
        }
        if(size.equalsIgnoreCase("medium")){
            price = 2.50;
        }
        if(size.equalsIgnoreCase("small")){
            price = 2.00;
        }

        Drink drink = new Drink(flavor, size, price);
        currentOrder.addProduct(drink);
    }

    public void addChips(){
        System.out.println("");
    }

    public void processCheckOut(){

    }

}
