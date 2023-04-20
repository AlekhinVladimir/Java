package OOP.Homework1;

public class BottleOfMilk extends Product{
    private int volume;
    private int fat;

    public BottleOfMilk(String brand, String name, double price, int volume, int fat){
        super(brand, name, price);
        this.volume = volume;
        this.fat = fat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    String displayInfo() {
        return String.format("Бренд: %s - Название: %s - Цена: %f - Объем: %d - Жирность: %d", brand, name, price, volume, fat);
    }
}