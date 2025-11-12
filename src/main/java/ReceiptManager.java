import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {



   private static String generateTimeStamp(){
       LocalDateTime now = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
       return now.format(formatter);
   }

    public static void saveReceipt(Order order){

       String timestamp = generateTimeStamp();
       String receipts = new String("src/main/java/Receipts" + generateTimeStamp() + ".txt");
       File file = new File(receipts);



        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Sale Receipt: " + timestamp + "\n");
            writer.write("=================================\n");
            writer.write(String.format(("%-20s %6s %8s %10s\n"), "Item", "Qty","Price", "Subtotal"));
            for (Product item : order.getItems()){
                writer.write(String.format("%-25s $%.2f%n", item.getName(), item.getPrice()));

            }
            writer.write("*******************************\n");
            writer.write("Total: " + order.getTotal());







        }    catch (IOException e) {
            throw new RuntimeException(String.valueOf(receipts));
        }


    }

}
