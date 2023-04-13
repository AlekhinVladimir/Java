// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2

package Homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 
 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phonebook = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить номер");
            System.out.println("2. Вывести весь справочник");
            int act = sc.nextInt();
            switch (act) {
                case 1:
                    Write(phonebook);
                    break;
                case 2:
                    Read(phonebook);
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    return;
            }
        }

    }
    //Метод для записи в книгу
    public static void Write(Map<String, ArrayList<String>> phonebook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String lastName = sc.nextLine();
        System.out.println("Введите номер телефона:");
        String phoneNumber = sc.nextLine();
        if (phonebook.containsKey(lastName)) {
            ArrayList<String> temp = phonebook.get(lastName);
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(phoneNumber);
            phonebook.put(lastName, temp);
        }
    }
    //Метод для чтения из книги
    public static void Read(Map<String, ArrayList<String>> phonebook) {
        for (var items : phonebook.entrySet()) {
            System.out.println(items.getKey() + " " + items.getValue());
        }
    }
}