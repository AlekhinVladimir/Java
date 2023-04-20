package OOP.Homework1;
public class Product {
    protected String name;
    protected String brand;
    protected double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0)
            this.price = 1;
        else
            this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3)
            this.name = "Продукт";
        else
            this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.length() < 1)
            this.brand = "ООО";
        else
            this.brand = brand;
    }

//    public Product(String name, double price){
//        this.name = name;
//        this.price = price;
//    }
//
//    public Product() {
//        this("Продукт", 1);
//    }

    public Product(String brand, String name, double price) {
        if (name.length() < 3)
            this.name = "Продукт";
        else
            this.name = name;
        if (brand.length() < 1)
            this.brand = "ООО";
        else
            this.brand = brand;
        if (price <= 0)
            this.price = 1;
        else
            this.price = price;
    }

    /**
     * Получить информацию по продукту
     * @return информацию по продукту
     */
    String displayInfo() {
        return String.format("Бренд: %s - Название: %s - Цена: %f", brand, name, price);
    }
}