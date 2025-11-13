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


        createSandwich();
        Bread.chooseBread();

        currentOrder.addProduct(sandwich);
    }
    public Sandwich createSandwich(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What size sandwich would you like?");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        String choice = scanner.nextLine().trim();
        String size = "";
        double basePrice = 0.00;
        double meatPrice = 0;
        double cheesePrice = 0;
        double extraMeatPrice = 0;
        double extraCheesePrice = 0;

        switch (choice){
            case"1":
                size = "small";
                basePrice = 5.50;
                meatPrice = 1.00;
                cheesePrice = 0.75;
                extraMeatPrice = 0.50;
                extraCheesePrice = 0.30;
                break;
            case "2":
                size = "medium";
                basePrice =7.00;
                meatPrice = 2.00;
                cheesePrice = 1.50;
                extraMeatPrice = 1.00;
                extraCheesePrice = 0.60;

                break;
            case "3":
                size = "large";
                basePrice =8.50;
                meatPrice = 3.00;
                cheesePrice = 2.25;
                extraMeatPrice = 1.50;
                extraCheesePrice = 0.90;

                break;
            default:
                System.out.println("not a valid option try again.");


        }
        Bread breadChoice = Bread.chooseBread();

        Sandwich sandwich = new Sandwich(size, breadChoice, basePrice);

        //Add meats
        System.out.println("Would you like to add a meat?");
        System.out.println("1:Steak | 2:Ham | 3:Salami | 4:Roast Beef | 5:Chicken | 6:Bacon | 7: No Meat ");
        String [] meatChoices = scanner.nextLine().split("");

        for (String m : meatChoices){
            switch (m){
                case "1":
                    sandwich.addTopping(new Meat("Steak", meatPrice));
                    break;
                case "2":
                    sandwich.addTopping(new Meat("Ham", meatPrice));
                    break;
                case "3":
                    sandwich.addTopping(new Meat("Salami", meatPrice));
                    break;
                case "4":
                    sandwich.addTopping(new Meat("Roast Beef", meatPrice));
                    break;
                case "5":
                    sandwich.addTopping(new Meat("Chicken", meatPrice));
                    break;
                case "6":
                    sandwich.addTopping(new Meat("Bacon", meatPrice));
                    break;
            }
        }

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
