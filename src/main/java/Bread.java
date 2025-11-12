import java.util.Scanner;

public class Bread {
    String type;

    public Bread (String type){
        this.type = type;
    }

    public String getType(){
        System.out.println("What kind of bread would you like?");
        System.out.println("1: White | 2: Wheat | 3: rye | 4: Wrap");
        Scanner breadType = new Scanner(System.in);

        switch (breadType){
            case "1":
                type = "white";
                break;
            case "2":
                type = "wheat";

        }

        return type;
    }
}
