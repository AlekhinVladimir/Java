package Homework4_1;

// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;
public class Task2 {
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        System.out.println("Исходная очередь: " + list);
        int element = 23;
        enqueue(list, element);
        System.out.println("Первый элемент очереди: " + dequeue(list));
        System.out.println("Очередь без первого элемента: " + list);
        System.out.println("Первый элемент из очереди: " + first(list));
        System.out.println("Исходная очередь: " + list);

    }
    public static void enqueue(LinkedList<Integer> list, int element) {
        list.addLast(element);
        System.out.println("Поместили элемент в конец очереди: " + list);
    }
    public static int dequeue(LinkedList<Integer> list) {
        int result = list.getFirst();
        list.removeFirst();
        return result;
        
    }
    public static int first(LinkedList<Integer> list) {
        int result = list.getFirst();
        return result;
}
}
