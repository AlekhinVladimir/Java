// (Дополнительное) Реализовать алгоритм сортировки слиянием
package Homework3;

import java.util.Arrays;
import java.util.Random;

public class Task3_1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Первоначальный массив: " + Arrays.toString(array));
        System.out.println("Отсортированный массив: " + Arrays.toString(mergeSort(array)));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;
        int[] leftArr = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] rightArr = Arrays.copyOfRange(array, leftArr.length, array.length);
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int resInd = 0, leftInd = 0, rightInd = 0;
        int[] result = new int[leftArr.length + rightArr.length];

        while (leftInd < leftArr.length && rightInd < rightArr.length)
            result[resInd++] = (leftArr[leftInd] < rightArr[rightInd]) ? leftArr[leftInd++] : rightArr[rightInd++];

        while (resInd < result.length)
            result[resInd++] = (leftInd != leftArr.length) ? leftArr[leftInd++] : rightArr[rightInd++];

        return result;
    }
}
