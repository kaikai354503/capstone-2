import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order implements Product {
    double price;
    LocalDateTime orderDate;
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

public void printReceipt(){
    System.out.println("Receipt: ");
    //for (Product p: items){
       // System.out.println(p.getName(), p.getPrice());
    //}
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
