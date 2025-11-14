public class Toppings {
    private String name;
    private double price;
    private boolean isPremium;

    public Toppings(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return  name;
    }

    public double getPrice(){
        return price;
    }




    public boolean isMeat(){
        return false;
    }
    public boolean  isCheese(){
        return false;
    }

    public boolean  isFreeTopping(){
        return false;
    }
}
