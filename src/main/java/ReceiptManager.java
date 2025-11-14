import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {



   private static String generateTimeStamp(){
       LocalDateTime now = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");
       return now.format(formatter);
   }

    public static void saveReceipt(Order order){

       String timestamp = generateTimeStamp();
       String receipts = new String("src/main/resources/Receipts/" + generateTimeStamp() + ".txt");
       File file = new File(receipts);
        String itemName;


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){

            int maxDescLength = 50;

            for(Product item : order.getItems()){
               String name;
                if (item.isSandwich()){
                    name =((Sandwich)item).toString();
                }
                else {
                    name = item.getName();
                }

                maxDescLength = Math.max(maxDescLength, name.length());

                if(item.isSandwich()){
                    Sandwich s = (Sandwich) item;
                    for (Toppings t : s.getToppings()) {
                        if (t.isFreeTopping()) {
                            maxDescLength = Math.max(maxDescLength, t.getName().length() + 3);
                        }
                    }

                    if(s.isToasted()){
                            maxDescLength = Math.max(maxDescLength, "Toasted".length() + 3);
                    }

                }
            }

            String itemFormat = "%-" + (maxDescLength + 2) + "s | 4%7.2f%n";
            String toppingFormat = "    + %-" + (maxDescLength - 1) + "s%n";


            writer.write("Customer:" + order.getCustomerName() + "'s    ");
            writer.write("Sale Receipt: " + timestamp + "\n");
            writer.write("=".repeat(maxDescLength + 20) + "\n");
            writer.write(String.format("%-" + (maxDescLength + 2) + "s %11s%n", "Item Description", "price" ));
            writer.write("=".repeat(maxDescLength + 20) + "\n");

            for (Product item : order.getItems()){
                if(item.isSandwich()) {
                    Sandwich sandwich = (Sandwich) item;

                    writer.write(String.format(itemFormat,
                            sandwich.toString(),
                            sandwich.getPrice()
                    ));

                    for (Toppings topping : sandwich.getToppings()) {


                        if (topping.isFreeTopping()) {
                            writer.write(String.format(toppingFormat,
                                    topping.getName()
                            ));
                        }
                    }

                    if (sandwich.isToasted()) {
                        writer.write(String.format(toppingFormat, "Toasted"));
                    }
                }
                else {
                    writer.write(String.format(itemFormat,
                            item.getName(),
                            item.getPrice()
                    ));
                }
            }





            writer.write("=".repeat(maxDescLength + 20) + "\n");
            writer.write(String.format(itemFormat, "Total: ",order.getTotal()));








        }    catch (IOException e) {
            throw new RuntimeException(String.valueOf(receipts));
        }


    }

}
