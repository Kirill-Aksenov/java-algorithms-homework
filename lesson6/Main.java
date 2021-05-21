package lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long timeCheck;

        Tree tree = new Tree();
        tree.insert(new Person(1, "Кирилл", 30));
        tree.insert(new Person(2, "Андрей", 55));
        tree.insert(new Person(3, "Сергей", 46));
        tree.insert(new Person(4, "Михаил", 36));
        tree.insert(new Person(5, "Виктор", 15));

        System.out.print("Задания 6.2 - 6.5\nРезультат выполнения метода displayTree():");
        timeCheck = System.nanoTime();
        tree.displayTree();
        System.out.println("\nРезультат выполнения методов findMin() и findMax():");
        tree.findMin().display();
        tree.findMax().display();
        System.out.println("\nРезультат выполнения метода find(3):");
        tree.find(3).display();
        tree.delete(4);
        System.out.println("\nВыполним метод delete(4) и посмотрим на изменившийся результат метода displayTree():");
        tree.displayTree();
        System.out.println("\nВремя выполнения данных методов заняло: " + (System.nanoTime() - timeCheck) + " наносекунд");

        System.out.println("\nЗадание 6.6");
        int[] array = { 12, 54, 99, 13, 21, 67, 40, 80, 42, 72 };
        System.out.println("Базовый массив: " + Arrays.toString(array));
        timeCheck = System.nanoTime();
        HeapSort.sort(array);
        System.out.println("Результат пирамидальной сортировки: " + Arrays.toString(array));
        System.out.println("Время выполнения данной сортировки заняло: " + (System.nanoTime() - timeCheck) + " наносекунд");
    }
}