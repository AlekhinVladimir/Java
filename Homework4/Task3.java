package Homework4;

// В калькулятор добавьте возможность отменить последнюю операцию.
// Пример:
// 1
// +
// 2
// ответ:
// 3

// +
// 4
// ответ:
// 7
// +
// 2

// ответ:
// 9
// -
// 1
// Ответ 8
// Отмена -> 9
// Отмена -> 7
// Отмена -> 3
// +
// 2
// Ответ 5


import java.util.Scanner;
//import java.util.Stack;

public class Task3 {
    private static double result = 0;
    private static double prevResult = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double num1 = getDouble(scanner);
        System.out.println("Введите операцию (+, -, *, /):");
        char operation = getOperation(scanner);
        System.out.println("Введите второе число:");
        double num2 = getDouble(scanner);
        result = calc(num1, num2, operation);
        System.out.println("Результат: " + result);

        while (true) {
            System.out.println("Введите операцию (+, -, *, /), 'c' для отмены предыдущей операции или 'q' для выхода:");
            operation = getOperation(scanner);
            if (operation == 'q') {
                System.out.println("До свидания!");
                break;
            } else if (operation == 'c') {
                System.out.println("Предыдущий результат: " + prevResult);
                result = prevResult;
            } else {
                System.out.println("Введите число:");
                num2 = getDouble(scanner);
                prevResult = result;
                result = calc(result, num2, operation);
                System.out.println("Результат: " + result);
            }
        }
    }

    private static double getDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private static char getOperation(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 1 && "+-*/cq".contains(input)) {
                return input.charAt(0);
            }
            System.out.println("Ошибка: введите один из символов (+, -, *, /, c,q).");
        }
    }

    private static double calc(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль.");
                    return num1;
                }
                return num1 / num2;
            default:
                return num1;
        }
    }

}