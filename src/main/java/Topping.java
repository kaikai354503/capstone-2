public class Topping {
    private String name;
    private double price;
    private boolean isPremium;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return  name;
    }

    public double getPrice(){
        return price;
    }

    public boolean isPremium(){
        return isPremium;
    }
    public class Meat extends Topping{
        public Meat(String name, double price){
            super(name, price);
        }
    }
}
