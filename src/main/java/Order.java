import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    LocalDateTime orderDate;
    double price;
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
