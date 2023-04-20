package OOP.Homework1;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public static void main(String[] args) {

//        Product product1 = new Product();
//        product1.setName("Бутылка с водой");
//        product1.setPrice(100.12);
//        product1.setBrand("ООО");
//
//        Product product2 = new Product("Бутылка с молоком", 200);
//        Product product3 = new Product("Бутылка с соком", "ООО", 200);
//
//        System.out.println(product1.displayInfo());
//        System.out.println(product2.displayInfo());
//        System.out.println(product3.displayInfo());

        BottleOfWater bottle1 = new BottleOfWater("Аква", "Вода", 100, 1);
        System.out.println(bottle1.displayInfo());

        Product bottle2 = new BottleOfWater("Витель", "Вода", 50, 2);
        System.out.println(bottle2.displayInfo());

        Product bottle3 = new BottleOfMilk("Буренка", "Молоко", 50, 2, 3);
        System.out.println(bottle3.displayInfo());

        Product bottle4 = new BottleOfMilk("Домик в деревне", "Молоко", 30, 1, 1);
        System.out.println(bottle4.displayInfo());

        Product chocolate1 = new Chocolate("Аленка", "Шоколад", 100, 250);
        System.out.println(chocolate1.displayInfo());

        Product chocolate2 = new Chocolate("Красный октябрь", "Шоколад", 200, 150);
        System.out.println(chocolate2.displayInfo());

        System.out.println("-----------------------------------------------------");

        List<Product> products = new ArrayList<>();
        products.add(bottle1);
        products.add(bottle2);
        products.add(bottle3);
        products.add(bottle4);
        products.add(chocolate1);
        products.add(chocolate2);

        VendingMachine machine = new VendingMachine(products);

        BottleOfWater bottleOfWaterRes = machine.getBottleOfWater("Вода", 2);
        if(bottleOfWaterRes != null){
            System.out.println("Вы купили воду: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else
            System.out.println("Такой воды нет");

        BottleOfMilk bottleOfMilkRes = machine.getBottleOfMilk("Молоко", 2);
        if(bottleOfMilkRes != null){
            System.out.println("Вы купили молоко: ");
            System.out.println(bottleOfMilkRes.displayInfo());
        }
        else
            System.out.println("Такого молока нет");

        Chocolate chocolateRes = machine.getChocolate("Шоколад", 250);
        if(chocolateRes != null){
            System.out.println("Вы купили шоколад: ");
            System.out.println(chocolateRes.displayInfo());
        }
        else
            System.out.println("Такого шоколада нет");

    }
}