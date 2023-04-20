package OOP.Homework1;

public class Chocolate extends Product{

    private int calories;

    public Chocolate(String brand, String name, double price, int calories) {
        super(brand, name, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    String displayInfo() {
        return String.format("Бренд: %s - Название: %s - Цена: %f - Калории: %d", brand, name, price, calories);
    }
}