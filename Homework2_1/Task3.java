// 3) Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
package Homework2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try {
            File file = new File("Homework2_1\\Task3.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String surname = parts[0].split(":")[1].replace("\"", "");
                String mark = parts[1].split(":")[1].replace("\"", "");
                String subject = parts[2].split(":")[1].replace("\"", "");
                stringBuilder.append("Студент ")
                        .append(surname)
                        .append(" получил ")
                        .append(mark)
                        .append(" по предмету ")
                        .append(subject)
                        .append(".\n");
            }
            System.out.println(stringBuilder.toString());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
