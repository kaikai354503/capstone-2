import java.util.Scanner;

public class Bread {
   private String type;

    public Bread (String type){
        this.type = type;
    }

    public  String getType(){
        return type;
    }

    public static Bread chooseBread(){
        Scanner scanner = new Scanner(System.in);
        String type = "";

        System.out.println("What kind of bread would you like?");
        System.out.println("1: White | 2: Wheat | 3: rye | 4: Wrap");

        String breadType = scanner.nextLine().toLowerCase();

        switch (breadType){
            case "1":
                type = "white";
                break;
            case "2":
                type = "wheat";
                break;
            case "3":
                type = "rye";
                break;
            case "4":
                type = "wrap";
                break;
            default:
                System.out.println("not a valid option try again.");
        }

        return new Bread(type);
    }


}
