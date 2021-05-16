package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        long timeCheck;

        Integer[] array = { 1, 7, 14, 36, 41, 54, 65, 71, 85 };
        System.out.println("Задание 3.1\nБазовый массив: " + Arrays.toString(array));
        timeCheck = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println("Полученный список: " + arrayList);
        System.out.println("Время преобразования массива в список заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\n");

        System.out.println("Задание 3.2\nДобавление элемента: ");
        timeCheck = System.nanoTime();
        arrayList.add(100);
        System.out.println("Список после добавления элемента: " + arrayList);
        System.out.println("Время добавления элемента в список заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд");
        System.out.println("Удаление элемента:");
        timeCheck = System.nanoTime();
        arrayList.remove(9);
        System.out.println("Список после удаления элемента: " + arrayList);
        System.out.println("Время удаления элемента из списка заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд");
        timeCheck = System.nanoTime();
        System.out.println("Получение элемента из списка: " + arrayList.get(1));
        System.out.println("Время получения элемента из списка заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\n");

        System.out.println("Задание 3.3");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 5; i++) list.insert(i);
        System.out.print("Полученный односвязный список: ");
        list.display();
        System.out.println("\nПроверяем методом isEmpty(), является ли список пустым : " + list.isEmpty());
        list.delete();
        System.out.print("Список после применения метода delete(): ");
        list.display();
        System.out.print("\nПример поиска нужного элемента с помощью метода find(): " + list.find(1) + "\n\n");

        System.out.println("Задание 3.4");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(0, arrayList);
        linkedList.add(100);
        System.out.println("Добавление элемента в двусторонний список: " + linkedList);
        linkedList.set(0, 200);
        System.out.println("Замена элемента в двустороннем списке: " + linkedList);
        linkedList.remove(0);
        System.out.println("Удаление элемента в двустороннем списке: " + linkedList);
        linkedList.addFirst(0);
        linkedList.addLast(999);
        System.out.println("Добавление первого и последнего элементов в двустороннем списке: " + linkedList + "\n");

        System.out.print("Задание 3.5\nПроверяем, содержит ли связанный список следующий элемент, методом hasNext(): ");
        ListIterator<Integer> iterator = linkedList.listIterator();
        timeCheck = System.nanoTime();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println("\nВремя выполнения этого метода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд");
        System.out.print("Проверяем, содержит ли связанный список предыдущий элемент, методом hasPrevious(): ");
        timeCheck = System.nanoTime();
        while (iterator.hasPrevious()) System.out.print(iterator.previous() + " ");
        System.out.println("\nВремя выполнения этого метода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд");
        timeCheck = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println("Время удаления данных из связанного списка заняло: " + (System.nanoTime() - timeCheck)
                + " наносекнуд");
    }
}