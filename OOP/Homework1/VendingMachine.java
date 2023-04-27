package Homework1;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products){
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume){
        for (Product product: products) {
            if(product instanceof BottleOfWater){
                if (product.getName().equals(name) && ((BottleOfWater) product).getVolume() == volume) {
                    return (BottleOfWater) product;
                }
            }
        }
        return null;
    }

    public BottleOfMilk getBottleOfMilk(String name, int volume){
        for (Product product: products) {
            if(product instanceof BottleOfMilk){
                if (product.getName().equals(name) && ((BottleOfMilk) product).getVolume() == volume) {
                    return (BottleOfMilk) product;
                }
            }
        }
        return null;
    }

    public Chocolate getChocolate(String name, int calories){
        for (Product product: products) {
            if(product instanceof Chocolate){
                if (product.getName().equals(name) && ((Chocolate) product).getCalories() == calories) {
                    return (Chocolate) product;
                }
            }
        }
        return null;
    }
}