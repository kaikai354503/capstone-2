import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order implements Product {
    double price;
    LocalDateTime orderDate;
    private double totalPrice = 0.0;



Scanner scanner = new Scanner(System.in);
public ArrayList<Product> items = new ArrayList<>();


public Order(List<Product> initialItems){
    this.items.addAll(initialItems);

}


public void homeScreen (){
    Boolean running = true;
    while(running) {
        System.out.println("1) Place a new order.");
        System.out.println("2) exit.");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":orderScreen();
                break;
            case "2":
                System.out.println("Thanks for stoping by!");
            return;

            default:
                System.out.println("Not a valid option");

        }
    }

}

public void orderScreen(){
    System.out.println("1) add chip.");
    System.out.println("2) add drink.");
    System.out.println("3) go back.");

    String choice = scanner.nextLine().trim();
    switch (choice){
        case "1":
            return;
        case "2":

        case "3": homeScreen();

    }
}

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }


    private void updateTotal(){
    this.totalPrice = 0.0;
    for(Product item : items){
        this.totalPrice += item.getPrice();
    }
    }

    public double getTotalPrice(){
    return this.totalPrice;
    }
}
