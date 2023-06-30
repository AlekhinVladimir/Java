// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package Homework2_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

public class Task1 {

    public static void main(String[] args) {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM students ");
      
        queryBuilder.append("WHERE ");  

        try (BufferedReader br = new BufferedReader(new FileReader("Homework2_1\\Task1.json"))) {
            String jsonString = br.readLine();
            JSONObject jsonObject = new JSONObject(jsonString);

            if (!jsonObject.getString("name").equals("null")) { 
                queryBuilder.append("name = '" + jsonObject.getString("name") + "' AND ");
            }

            if (!jsonObject.getString("country").equals("null")) {
                queryBuilder.append("country = '" + jsonObject.getString("country") + "' AND ");
            }

            if (!jsonObject.getString("city").equals("null")) {
                queryBuilder.append("city = '" + jsonObject.getString("city") + "' AND ");
            }

            if (!jsonObject.getString("age").equals("null")) {
                queryBuilder.append("age = '" + jsonObject.getString("age") + "' AND ");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении данных из файла: " + e);
        }     
        queryBuilder.setLength(queryBuilder.length() - 5); 
        String query = queryBuilder.toString();

        System.out.println("Result query: " + query);
    }
}
