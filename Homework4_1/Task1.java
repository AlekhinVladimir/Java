// Пусть дан LinkedList с несколькими элементами.
//  Реализуйте метод, который вернет “перевернутый” список.

package Homework4_1;

import java.util.Collections;
import java.util.LinkedList;

public class Task1 {
public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        LinkedList<String> reversedList = reverseLinkedList(list);
        System.out.println(reversedList); 
    }

    public static LinkedList reverseLinkedList(LinkedList list) {
        Collections.reverse(list);
        return list;
    }
}
