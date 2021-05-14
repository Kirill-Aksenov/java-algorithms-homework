package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long timeCheck;
        long linearSearchTime;
        long binarySearchTime;
        long sortTime;
        long bubbleSortTime;
        long selectionSortTime;
        long insertionSortTime;

        Random random = new Random();
        int[] array = { 1, 7, 14, 36, 41, 54, 65, 71, 85 };

        System.out.println("Задание 2.1 Базовые операции класса Arrays");
        timeCheck = System.nanoTime();
        System.out.println("Обращение к массиву: " + Arrays.toString(array));
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("Обращение к скопированному массиву: " + Arrays.toString(arrayCopy));
        System.out.println("Результат сравнения массивов: " + Arrays.equals(array, arrayCopy));
        System.out.println("Время выполнения базовых операций класса Arrays заняло: " + (System.nanoTime() - timeCheck)
                + " наносекнуд\n");

        System.out.println("Задание 2.2");
        int keyNumber = array[random.nextInt(array.length)]; // рандомное число из массива для поиска
        timeCheck = System.nanoTime();
        System.out.println("Результат линейного поиска в массиве: " + linearSearch(array, keyNumber));
        linearSearchTime = System.nanoTime() - timeCheck;
        System.out.println("Время линейного поиска в массиве составило: " + linearSearchTime + " наносекунд");
        timeCheck = System.nanoTime();
        System.out.println("Результат бинарного поиска в массиве: " + Arrays.binarySearch(array, keyNumber));
        binarySearchTime = System.nanoTime() - timeCheck;
        System.out.println("Время бинарного поиска в массиве составило: " + binarySearchTime + " наносекунд\n");

        int[] arrayForTaskThree = new int[400];

        for (int i = 0; i < arrayForTaskThree.length; i++) {
            arrayForTaskThree[i] = random.nextInt(arrayForTaskThree.length);
        }
        int[] arrayForTaskFour = arrayForTaskThree.clone(); // копируем массив для следующих заданий
        int[] arrayForTaskFive = arrayForTaskThree.clone();
        int[] arrayForTaskSix = arrayForTaskThree.clone();
        System.out.println("Задание 2.3 \nНеотсортированный масив: " + Arrays.toString(arrayForTaskThree));
        timeCheck = System.nanoTime();
        Arrays.sort(arrayForTaskThree);
        sortTime = System.nanoTime() - timeCheck;
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayForTaskThree));
        System.out.println("Время сортировки массива методом sort() составило: " + sortTime + " наносекунд\n");

        System.out.println("Задание 2.4 \nНеотсортированный массив: " + Arrays.toString(arrayForTaskFour));
        timeCheck = System.nanoTime();
        bubbleSort(arrayForTaskFour);
        bubbleSortTime = System.nanoTime() - timeCheck;
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayForTaskFour));
        System.out.println("Сортировка пузырьком заняла: " + bubbleSortTime + " наносекунд");
        System.out.println("Сортировка методом sort() " + (sortTime > bubbleSortTime ? "медленнее" : "быстрее")
                + " чем сортировка пузырьком\n");

        System.out.println("Задание 2.5 \nНеотсортированный масив: " + Arrays.toString(arrayForTaskFive));
        timeCheck = System.nanoTime();
        selectionSort(arrayForTaskFive);
        selectionSortTime = System.nanoTime() - timeCheck;
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayForTaskFive));
        System.out.println("Сортировка методом выбора заняла: " + selectionSortTime + " наносекунд");
        System.out.println("Сортировка методом выбора " + (selectionSortTime > sortTime ? "медленнее" : "быстрее")
                + " чем сортировка методом sort()");
        System.out.println("Сортировка методом выбора " + (selectionSortTime > bubbleSortTime ? "медленнее" : "быстрее")
                + " чем сортировка пузырьком\n");

        System.out.println("Задание 2.6 \nНеотсортированный массив: " + Arrays.toString(arrayForTaskSix));
        timeCheck = System.nanoTime();
        insertionSort(arrayForTaskSix);
        insertionSortTime = System.nanoTime() - timeCheck;
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayForTaskSix));
        System.out.println("Сортировка методом вставки заняла: " + insertionSortTime + " наносекунд");
        System.out.println("Сортировка методом вставки " + (insertionSortTime > sortTime ? "медленнее" : "быстрее")
                + " чем сортировка методом sort()");
        System.out.println("Сортировка методом вставки " + (insertionSortTime > bubbleSortTime ? "медленнее" : "быстрее")
                + " чем сортировка пузырьком");
        System.out.println("Сортировка методом вставки " + (insertionSortTime > selectionSortTime ? "медленнее" : "быстрее")
                + " чем сортировка методом выбора");
    }

    public static boolean linearSearch(int[] array, int keyNumber) {
        for (int value : array) {
            if (value == keyNumber) {
                return true;
            }
        }
        return false;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int buffer = array[i];
            array[i] = array[min];
            array[min] = buffer;
        }
    }

    public static void insertionSort(int[] array) {
        int buffer;
        int in;
        for (int i = 1; i < array.length; i++) {
            buffer = array[i];
            in = i;
            while (in > 0 && array[in - 1] >= buffer) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = buffer;
        }
    }
}
