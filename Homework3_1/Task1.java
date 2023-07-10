package Homework3_1;

// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // удаляем четные элементы списка
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        System.out.println(oddNumbers);

        // отсортируем список чтобы найти минимальное и максимальное значения
        oddNumbers.sort(Integer::compareTo);
        int minNumber = oddNumbers.get(0);
        int maxNumber = oddNumbers.get(oddNumbers.size() - 1);
        System.out.println("Min: " + minNumber + " Max: " + maxNumber);

        // найдем среднее значение
        int sum = 0;
        for (Integer number : oddNumbers) {
            sum += number;
        }
        int average = (int) Math.round((double) sum / oddNumbers.size());
        System.out.println("Average: " + average);
    }
}