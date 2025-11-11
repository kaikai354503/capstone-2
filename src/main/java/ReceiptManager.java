import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {



   private String generateTimeStamp(){
       LocalDateTime now = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
       return now.format(formatter);
   }

    public void saveReceipt(Order order){

       String timestamp = generateTimeStamp();
       String receipts = new String("src/main/resources/Receipts.csv" + generateTimeStamp() + ".txt");
       File file = new File(receipts);



        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Sale Receipt: " + timestamp + "\n");
            writer.write("=================================");
            writer.write(String.format(("%-20s %6s %8s %10s\n"), "Item", "Qty","Price", "Subtotal"));
            for (Product item : order.items){
                double subTotal = item.getPrice() * item.getQty();

            }







        }    catch (IOException e) {
            throw new RuntimeException(String.valueOf(receipts));
        }


    }

}
