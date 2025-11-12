import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner  scanner = new Scanner(System.in);
    private String size;
    private double price;
    private  String firstName, lastName;
    private Bread bread;


    public void start(){
        currentOrder = new Order();
        getFullName();
        boolean ordering = true;

        while (ordering){
            displayMenu();
            String input = scanner.nextLine();

            switch (input){
                case"1":
                    break;
                case"2":
                    addDrink();
                    break;
                case"3":
                    addChips();
                    break;
                case"4":
                    ordering = false;
                    ReceiptManager.saveReceipt(currentOrder);
                    break;
                default:
                    System.out.println("not a valid input try again.");
                    break;
            }
        }
        System.out.println("Order complete! Total: $" + currentOrder.getTotal());
    }

    private void getFullName(){

        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine().trim().toLowerCase();
    }

    private void displayMenu(){
        System.out.println("====" + firstName + "'s" + "Order====");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chip");
        System.out.println("4) Check Out");
        System.out.println("Enter your choice: ");
    }


    public void displayOrder(){

    }

    public void processNewOrder(){

    }

    public void processAddProduct(){

    }
    private void addSandwich(){

        Sandwich sandwich = new Sandwich(size, bread, price);
        Sandwich.getSize();

        currentOrder.addProduct(sandwich);
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
        price = 2.50;

            Scanner choice = new Scanner(System.in);
            System.out.println("What kind of chips would you like? BBQ Lays | Cool Ranch Doritos | kettle Cooked Jalepenios");
            String flavor = choice.nextLine().trim();
            Chips chips = new Chips(flavor, price);
            currentOrder.addProduct(chips);
    }

    public void processCheckOut(){

    }

}
