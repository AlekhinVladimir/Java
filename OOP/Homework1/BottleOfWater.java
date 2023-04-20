package OOP.Homework1;

public class BottleOfWater extends Product{
    private int volume;

    public BottleOfWater(String brand, String name, double price, int volume){
        super(brand, name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    String displayInfo() {
        return String.format("Бренд: %s - Название: %s - Цена: %f - Объем: %d", brand, name, price, volume);
    }
}
