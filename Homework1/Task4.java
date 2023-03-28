// Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// под знаками вопроса - одинаковые цифра
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69

import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите уравнение вида q + w = e, где q, w, e >= 0, и некоторые цифры заменены знаком вопроса: ");
        String equation = input.nextLine();
        String[] parts = equation.split("[+=]");
        if (parts.length != 3) {
            System.out.println("Некорректный ввод.");
            return;
        }
        String Q = parts[0];
        String W = parts[1];
        String E = parts[2];
        for (int q = 0; q <= 9; q++) {
            String Q1 = replaceQuestionMark(Q, q);
            for (int w = 0; w <= 9; w++) {
                String W1 = replaceQuestionMark(W, w);
                for (int e = 0; e <= 9; e++) {
                    String E1 = replaceQuestionMark(E, e);
                    if (isValidEquation(Q1, W1, E1)) {
                        System.out.println(Q1 + " + " + W1 + " = " + E1);
                        return;
                    }
                }
            }
        }
        System.out.println("Решение не найдено.");
    }
    
    private static String replaceQuestionMark(String number, int digit) {
        return number.replaceFirst("\\?", String.valueOf(digit));
    }
    
    private static boolean isValidEquation(String A, String B, String C) {
        if (A.charAt(0) == '0' || B.charAt(0) == '0' || C.charAt(0) == '0') {
            return false; // числа не могут начинаться с нуля
        }
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);
        return a + b == c;
    }
}
