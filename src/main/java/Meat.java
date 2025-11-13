public class Meat extends Topping {
    private boolean extraMeat;
    public Meat(String name, double price) {
        super(name, price);
        this.extraMeat = extraMeat;
    }

    public boolean isExtraMeat(){

        return extraMeat;
    }


    public double getPrice(){
        double price = super.getPrice();{
            if(extraMeat){
                price += 0.75;
            }
        }
        return price;
    }


}
