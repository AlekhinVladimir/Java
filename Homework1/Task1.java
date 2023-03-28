// Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        int n = iScanner.nextInt();
        System.out.println(n);
        int triangle = (n * (n + 1)) / 2;
        int factorial = 1;
        for (int i = 1; i <= n; i++) 
        {
            factorial *= i;
        }
        System.out.println("Сумма чисел от 1 до " + n + " равна " + triangle);
        System.out.println("Произведение чисел от 1 до " + n + " равно " + factorial);
    }
}