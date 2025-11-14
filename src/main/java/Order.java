import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    LocalDateTime orderDate;

    String firstName;
    String lastName;
    private double totalPrice = 0.0;

    Scanner scanner = new Scanner(System.in);

    private ArrayList<Product> items = new ArrayList<>();


public void addProduct(Product product){
    items.add(product);
}

public List<Product> getItems(){
    return items;
}

public double getTotal(){
    double total = 0.0;
    for(Product p : items){
        total += p.getPrice();
    }
    return total;
}


public void setCustomer(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
}

String getCustomerName(){
    return firstName + " " + lastName;
}



    public double getTotalPrice(){
    return this.totalPrice;
    }
}
