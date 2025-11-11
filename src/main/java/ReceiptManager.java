import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

   String receipts = new String("src/main/resources/Receipts.csv");

   private String generateTimeStamp(){
       LocalDateTime now = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
       return now.format(formatter);
   }

    public void saveReceipt(Order order){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(receipts)){




        }    catch (IOException e) {
            throw new RuntimeException(receipts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
