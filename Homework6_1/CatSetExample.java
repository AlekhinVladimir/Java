package Homework6_1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Cat {
    private String name;
    private int age;
    private double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;
        return age == cat.age && Double.compare(cat.weight, weight) == 0 && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }
}

public class CatSetExample {
    public static void main(String[] args) {
        Set<Cat> catSet = new HashSet<>();
        
        Cat cat1 = new Cat("Барсик", 5, 4.2);
        Cat cat2 = new Cat("Мурзик", 3, 3.5);
        Cat cat3 = new Cat("Барсик", 5, 4.2);
        Cat cat4 = new Cat("Барсик", 4, 3.7);

        catSet.add(cat1);
        catSet.add(cat2);
        catSet.add(cat3);
        catSet.add(cat4);

        for (Cat cat : catSet) {
            System.out.println(cat.getName() + " " + cat.getAge() + " " + cat.getWeight());
        }
    }
}