// Задан целочисленный список ArrayList. 
// Найти минимальное, максимальное и среднее ариф. из этого списка

package Homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task3_3 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("Целочисленный список чисел: " + list);

        Integer[] arrayList = list.toArray(new Integer[0]);
        Arrays.sort(arrayList);

        System.out.println("Минимальное число в списке: " + arrayList[0]);
        System.out.println("Максимальное число в списке: " + arrayList[arrayList.length - 1]);
        int sum = 0;
        for (Integer elem : arrayList) {
            sum += elem;
        }
        double ave = (double) sum/ (double) arrayList.length;
        System.out.print("Среднеарифметическое чисел списка: " + ave);
    }  
}
