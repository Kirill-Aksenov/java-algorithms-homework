package lesson8;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Item dataItem;
        int size = 50;
        int key = 0;
        int elementsToFill = 10;

        System.out.println("Задание 8.4\nРеализуем хеш-таблицу размером " + size
                + " элемента(ов) методом линейного пробирования:");
        FirstHashTable firstHashTable = new FirstHashTable(size);
        for (int i = 0; i < elementsToFill; i++) {
            key = random.nextInt(100);
            dataItem = new Item(key);
            firstHashTable.insert(dataItem);
        }
        firstHashTable.display();
        System.out.println("Проверим, возвращает ли метод find() сгенерированное последним значение ключа: "
                + firstHashTable.find(key).getKey());

        System.out.println("\nЗадание 8.5\nРеализуем хеш-таблицу размером " + size
                + " элемента(ов) методом двойного хеширования:");
        SecondHashTable secondHashTable = new SecondHashTable(size);
        for (int i = 0; i < elementsToFill; i++) {
            key = random.nextInt(100);
            dataItem = new Item(key);
            secondHashTable.insert(dataItem);
        }
        secondHashTable.display();
        System.out.println("Проверим, возвращает ли метод find() сгенерированное последним значение ключа: "
                + secondHashTable.find(key).getKey());
    }
}