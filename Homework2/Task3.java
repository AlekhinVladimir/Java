// дополнительно. К калькулятору из предыдущего дз добавить логирование.



import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите знак операции (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        scanner.close();
        double result = 0.0;
        String operation = "";

        switch (operator) {
            case '+':
                result = num1 + num2;
                operation = "+";
                break;
            case '-':
                result = num1 - num2;
                operation = "-";
                break;
            case '*':
                result = num1 * num2;
                operation = "*";
                break;
            case '/':
                result = num1 / num2;
                operation = "/";
                break;
            default:
                System.out.println("Ошибка! Некорректный знак операции.");
                return;
        }

        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);

        try {
            FileWriter writer = new FileWriter("Homework2\\calculator.txt");
            writer.write(num1 + " " + operation + " " + num2 + " = " + result);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }
}
