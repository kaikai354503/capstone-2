import java.util.Scanner;

@SuppressWarnings("ALL")
public class Bread {
   private String type;
   public boolean choosingBread = true;

    public Bread (String type){
        this.type = type;
    }

    public  String getType(){
        return type;
    }
    

    public static Bread chooseBread(){
            Scanner scanner = new Scanner(System.in);
            String type = "";
        while (chooseBread().choosingBread) {
            System.out.println("What kind of bread would you like?");
            System.out.println("1: White | 2: Wheat | 3: rye | 4: Wrap");

            String breadType = scanner.nextLine().toLowerCase();

            switch (breadType) {
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
                    return chooseBread();
            }
        }


        return new Bread(type);
    }

    @Override
    public String toString(){
        return type;
    }
}
