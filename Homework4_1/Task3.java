package Homework4_1;

// 3. В калькулятор добавьте возможность отменить последнюю операцию.


import java.util.Scanner;

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

// Ниже вариант учителя:
// class Calculator {

//     private static File log;
//     private static FileWriter fileWriter;
//     private static Deque<Character> operationStack = new ArrayDeque<>();
//     private static Deque<String> resultStack = new ArrayDeque<>();
//     private static String lastResult;


//     public static void main(String[] args) throws IOException {
//         try {
//             log = new File("log.txt");
//             log.createNewFile();
//             fileWriter = new FileWriter(log, true);
//             Scanner scanner = new Scanner(System.in);
//             boolean calc = true;
//             while (calc){
//                 System.out.print("Введите первое число: ");
//                 int a = scanner.nextInt();
//                 System.out.print("Введите операцию (+ - * /) или < для отмены операции\nили ! для завершения работы приложения: ");
//                 char op = scanner.next().charAt(0);
//                 if (op == '!'){
//                     System.out.println("Завершение работы приложения.");
//                     return;
//                 }
//                 int b = 0;
//                 if (op != '<'){
//                     System.out.print("Введите второе число: ");
//                     b = scanner.nextInt();
//                 }

//                 int res;
//                 switch (op) {
//                     case '+':
//                         res = add(a, b);
//                         lastResult = "Результат операции: " + res;
//                         resultStack.push(lastResult);
//                         operationStack.push('+');
//                         logStep(lastResult);
//                         System.out.println(a + " + " + b + " = " + res);
//                         break;
//                     case '-':
//                         res = minus(a, b);
//                         lastResult = "Результат операции: " + res;
//                         resultStack.push(lastResult);
//                         operationStack.push('-');
//                         logStep(lastResult);
//                         System.out.println(a + " - " + b + " = " + res);
//                         break;
//                     case '*':
//                         res = multi(a, b);
//                         lastResult = "Результат операции: " + res;
//                         resultStack.push(lastResult);
//                         operationStack.push('*');
//                         logStep(lastResult);
//                         System.out.println(a + " * " + b + " = " + res);
//                         break;
//                     case '/':
//                         res = divide(a, b);
//                         lastResult = "Результат операции: " + res;
//                         resultStack.push(lastResult);
//                         operationStack.push('/');
//                         logStep(lastResult);
//                         System.out.println(a + " / " + b + " = " + res);
//                         break;
//                     case '<':
//                         System.out.println("Предыдущая операция: " + resultStack.peekFirst());
//                         operationStack.removeFirst();
//                         resultStack.removeFirst();
//                         break;
//                     default:
//                         logStep("Некорректная операция!");
//                         System.out.println("Некорректная операция!");
//                         break;
//                 }
//             }
//         }
//         finally {
//             fileWriter.close();
//         }
//     }

//     private static int divide(int a, int b) {
//         if (b != 0) return a / b;
//         return -1;
//     }

//     private static int multi(int a, int b) {
//         return a * b;
//     }

//     private static int minus(int a, int b) {
//         return a - b;
//     }

//     private static int add(int a, int b) {
//         return a + b;
//     }

//     public static void logStep(String note) throws IOException {
//         fileWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
//     }

// }