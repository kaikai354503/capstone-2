import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner  scanner = new Scanner(System.in);
    private String size;
    private double price;
    private  String firstName, lastName;
    private Bread bread;
    boolean ordering;


    public void start(){
        currentOrder = new Order();
        getFullName();
        ordering = true;

        while (ordering){
            displayMenu();
            String input = scanner.nextLine();

            switch (input){
                case"1":
                    createSandwich();
                    break;
                case"2":
                    addDrink();
                    break;
                case"3":
                    addChips();
                    break;
                case"4":
                    processCheckOut();
                    break;
                case"5":
                    start();
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

        currentOrder.setCustomer(firstName, lastName);
    }

    private void displayMenu(){
        System.out.println("====" + firstName + "'s" + "Order====");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chip");
        System.out.println("4) Check Out");
        System.out.println("5) Cancel");
        System.out.println("Enter your choice: ");
    }


    public void displayOrder(){

    }


    public Sandwich createSandwich(){


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

        sandwich.askToasted();

        //Add meats
        System.out.println("Choose one meat.");
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
                case "7":
                    sandwich.addTopping(new Meat("", 0));
            }
        }
        // asks for double meat.
        System.out.println("Do you want double meat? Y/N");
        if (scanner.nextLine().toUpperCase().trim().equals("Y") && price > 0 ){
            sandwich.addTopping(new Meat("Double Meat", extraMeatPrice));
        }

        //add cheese
        System.out.println("Choose one cheese");
        System.out.println("1:American | 2:Provolone | 3:Cheddar | 4:Swiss | 5:No Cheese" );
        String cheeseChoice = scanner.nextLine().trim();

        switch (cheeseChoice){
            case "1":
                sandwich.addTopping(new Cheese("American", cheesePrice));
                break;
            case "2":
                sandwich.addTopping(new Cheese("Provolone", cheesePrice));
                break;
            case "3":
                sandwich.addTopping(new Cheese("Cheddar", cheesePrice));
                break;
            case "4":
                sandwich.addTopping(new Cheese("Swiss", cheesePrice));
                break;
            case "5":
                sandwich.addTopping(new Cheese("", 0));
                break;
            default:
                System.out.println("not a valid entry.");
        }
        //extra cheese
        System.out.println("Do you want double cheese? Y/N");
        if (scanner.nextLine().toUpperCase().trim().equals("Y") && price > 0 ){
            sandwich.addTopping(new Cheese("Double Cheese", extraCheesePrice));
        }
        //Extra toppings
        System.out.println("Select one free topping.");
        System.out.println("1:Lettuce | 2:Tomato | 3:Onion | 4:Pickles | 5:Olives | 6:Peppers | 7:Cucumber | 8:Jalepeños | 9:Guacamole | 10:Mushrooms | 11:Next");
        String [] toppingsChoices = scanner.nextLine().split(" ");

        for (String t: toppingsChoices){
            switch (t){
                case "1":
                    sandwich.addTopping(new FreeToppings("Lettuce", 0.0));
                    break;
                case "2":
                    sandwich.addTopping(new FreeToppings("Tomato", 0.0));
                    break;
                case "3":
                    sandwich.addTopping(new FreeToppings("Onion", 0.0));
                    break;
                case "4":
                    sandwich.addTopping(new FreeToppings("Pickles", 0.0));
                    break;
                case "5":
                    sandwich.addTopping(new FreeToppings("Olives", 0.0));
                    break;
                case "6":
                    sandwich.addTopping(new FreeToppings("Peppers", 0.0));
                    break;
                case "7":
                    sandwich.addTopping(new FreeToppings("Cucumber", 0.0));
                    break;
                case "8":
                    sandwich.addTopping(new FreeToppings("Jalepeños", 0.0));
                    break;
                case "9":
                    sandwich.addTopping(new FreeToppings("Guacamole", 0.0));
                    break;
                case "10":
                    sandwich.addTopping(new FreeToppings("Mushrooms", 0.0));
                    break;
                case "11":
                    break;
                default:
                    System.out.println("try again bud...");
            }
        }

        System.out.println("Select one sauce.");
        System.out.println("1:Mayo | 2:Ketchup | 3:Mustard | 4:Ranch | 5:Thousand Island | 6:Vinaigrette | 7:No sauce ");
        toppingsChoices = scanner.nextLine().split(" ");

        for (String t: toppingsChoices){
            switch (t){
                case "1":
                    sandwich.addTopping(new FreeToppings("Mayo", 0.0));
                    break;
                case "2":
                    sandwich.addTopping(new FreeToppings("Ketchup", 0.0));
                    break;
                case "3":
                    sandwich.addTopping(new FreeToppings("Mustard", 0.0));
                    break;
                case "4":
                    sandwich.addTopping(new FreeToppings("Ranch", 0.0));
                    break;
                case "5":
                    sandwich.addTopping(new FreeToppings("Thousand Island", 0.0));
                    break;
                case "6":
                    sandwich.addTopping(new FreeToppings("vinaigrette", 0.0));
                    break;
                case "7":
                    break;
                default:
                    System.out.println("try again bud...");
                    break;
            }
        }
        System.out.println("Sandwich added to order.");
        System.out.println(sandwich);
        currentOrder.addProduct(sandwich);
        return sandwich;
    }



    private void addDrink(){
        System.out.println("what drink would you like? 1: water | 2: soda ");
        String flavor = scanner.nextLine().trim();
        switch(flavor){
            case"1":
                flavor = "water";
                price = 0.00;
            case "2":
                flavor = "soda";

            default:

        }


        if(flavor.equals("water")){
            price = 0.00;
        } else if (flavor.equals("soda")) {
            System.out.println("What size would you like? 1:Small | 2:Medium | 3:Large");
            size = scanner.nextLine().trim();


            switch (size){
                case"1":
                    size = "small";
                    price = 2.00;
                    break;
                case"2":
                    size = "medium";
                    price = 2.50;
                    break;
                case"3":
                    size = "large";
                    price = 3.00;
                    break;
            }
        }

        Drink drink = new Drink(flavor, size, price);
        currentOrder.addProduct(drink);
    }

    public void addChips(){
        price = 2.50;

            Scanner choice = new Scanner(System.in);
            System.out.println("What kind of chips would you like? 1: BBQ Lays | 2: Cool Ranch Doritos | 3: kettle Cooked Jalepeñios");
            String flavor = choice.nextLine().trim();
            switch (flavor){
                case "1":
                    flavor = "BBQ Lays";
                    break;
                case "2":
                    flavor = "Cool Ranch Doritos";
                    break;
                case "3":
                    flavor = "kettle Cooked Jalepeñios";
                    break;
            }
            Chips chips = new Chips(flavor, price);
            currentOrder.addProduct(chips);
    }

    public void processCheckOut(){
        System.out.println("Ready to check out? 1: Confirm | 2: cancel"  );
        String choice = scanner.nextLine().trim();

        switch (choice){
            case"1":
                ordering = false;
                ReceiptManager.saveReceipt(currentOrder);
                break;
            case "2":
                start();
                break;
            default:
                System.out.println("Try again bud.");
        }

    }



    public void getFirstName(){
        this.firstName =firstName;

    }

}
