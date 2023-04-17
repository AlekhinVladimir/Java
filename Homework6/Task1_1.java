package Homework6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1_1 {
    public static void main(String[] args) {

        NoteBook n1 = new NoteBook("Apple", 16, 512, "MacOs", "silver");
        NoteBook n2 = new NoteBook("Dell", 8, 256, "Windows", "black");
        NoteBook n3 = new NoteBook("Asus", 4, 128, "Linux", "white");
        NoteBook n4 = new NoteBook("Lenovo", 8, 512, "Windows", "black");
        NoteBook n5 = new NoteBook("Apple", 32, 1024, "MacOs", "silver");
        Set<NoteBook> list = new LinkedHashSet<>(Set.of(n1, n2, n3, n4, n5));

        choiseNotebook(list, filter());
    }

    public static HashMap<String, Object> filter() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Object> custom = new HashMap<String, Object>();
        custom.put("ram", 0);
        custom.put("hdd", 0);
        custom.put("os", "");
        custom.put("color", "");
        System.out.println("\nПриступаем к подбору оптимальной модели ноутбука");
        while (true) {
            System.out.println("\n1. Объем RAM");
            System.out.println("2. Объем HDD");
            System.out.println("3. OS");
            System.out.println("4. Цвет");
            System.out.println("0. Завершить подбор и вывести подходящую модель ");
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nВведите минимальный объем RAM: ");
                    int ram = sc.nextInt();
                    custom.put("ram", ram);
                    break;

                case 2:
                    System.out.println("\nВведите минимальный объем HDD: ");
                    int hdd = sc.nextInt();
                    custom.put("hdd", hdd);
                    break;

                case 3:
                    System.out.println("\nВыберите OS из списка\n");
                    System.out.println("1. Windows");
                    System.out.println("2. Linux");
                    System.out.println("3. MacOs");
                    System.out.println("Введите цифру, соответствующую необходимому критерию: ");
                    int choiceOs = sc.nextInt();
                    switch (choiceOs) {
                        case 1:
                            custom.put("os", "Windows");
                            break;
                        case 2:
                            custom.put("os", "Linux");
                            break;
                        case 3:
                            custom.put("os", "MacOs");
                            break;
                        default:
                            System.out.println("Ошибка выбора");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("\nВыберите цвет из списка\n");
                    System.out.println("1. Серебряный");
                    System.out.println("2. Белый");
                    System.out.println("3. Черный");
                    System.out.println("Введите цифру, соответствующую необходимому критерию: ");
                    int choiceColor = sc.nextInt();
                    switch (choiceColor) {
                        case 1:
                            custom.put("color", "silver");
                            break;
                        case 2:
                            custom.put("color", "white");
                            break;
                        case 3:
                            custom.put("color", "black");
                            break;
                        default:
                            System.out.println("Ошибка выбора");
                            break;
                    }
                    break;

                case 0:
                    sc.close();
                    return custom;

                default:
                    System.out.println("Ошибка выбора");
                    break;
            }

        }

    }

    public static void choiseNotebook(Set<NoteBook> list, HashMap<String, Object> filter) {
        ArrayList<NoteBook> result = new ArrayList<>();
        for (NoteBook element: list) {
            if (element.getRam() >= (Integer) filter.get("ram") &&
                    element.getHdd() >= (Integer) filter.get("hdd") &&
                    (element.getOs().equals((String) filter.get("os"))
                            || filter.get("os").equals(""))
                    &&
                    (element.getColor().equals((String) filter.get("color"))
                            || filter.get("color").equals(""))) {
                result.add(element);
            }
        }
        if (result.size() == 0)
            System.out.println("Ноутбук под ваши параметры не найден.");
        else {
            System.out.println("\nПод ваши параметры подойдут следующие ноутбуки:");
            for (int index = 0; index < result.size(); index++) {
                System.out.println(result.get(index));
            }
        }

    }
}