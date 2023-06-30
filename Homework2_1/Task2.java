// 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

package Homework2_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();
        scanner.close();

        int[] arr = generateRandomArray(length);
        System.out.println("Исходный массив: " + arrayToString(arr));

        try {
            FileWriter writer = new FileWriter("Homework2_1\\log2.txt");
            writer.write("Исходный массив: " + arrayToString(arr) + "\n");
            bubbleSort(arr, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] arr, FileWriter writer) throws IOException { //пузырьковый метод сортировки
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            writer.write("Итерация " + (i + 1) + ": " + arrayToString(arr) + "\n"); // Запись текущего состояния массива в лог-файл
        }
        writer.write("Отсортированный массив: " + arrayToString(arr) + "\n");
        System.out.println("Отсортированный массив: " + arrayToString(arr));
    }

    public static int[] generateRandomArray(int length) { //рандомный массив
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(99) + 1; // генерируем числа от 1 до 99
        }
        return arr;
    }

    public static String arrayToString(int[] arr) { // Метод для преобразования массива в строку
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
