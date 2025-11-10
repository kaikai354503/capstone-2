import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {

   String receipts = new String("src/main/resources/Receipts.csv");


    public void saveReceipt(Order order){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(receipts)){
            writer.wrie



        }    catch (IOException e) {
            throw new RuntimeException(receipts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
