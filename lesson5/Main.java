package lesson5;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int[] ARRAY_FOR_CYCLE = new int[20];
    private static final int[] ARRAY_FOR_RECURSION = new int[20];
    private static int value = 0;

    public static void main(String[] args) {
        long timeCheck;

        System.out.println("Задание 5.2\nМетод обычной рекурсии с условием для выхода: ");
//        recursionMethod(value); // метод с бесконечной рекурсией закомментирован
        recursionMethodWithExit(1);

        System.out.print("\n\nЗадание 5.4\nЗаполняем массив с помощью цикла: ");
        timeCheck = System.nanoTime();
        cyclicallyFillTheArray();
        System.out.println(Arrays.toString(ARRAY_FOR_CYCLE));
        System.out.print("Время заполнения массива с помощью цикла заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\nЗаполняем массив с помощью рекурсии: ");
        timeCheck = System.nanoTime();
        recursivelyFillTheArray(1);
        System.out.println(Arrays.toString(ARRAY_FOR_RECURSION));
        System.out.println("Время заполнения массива с помощью рекурсии заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\n");

        System.out.println("Задание 5.6");
        int[] arrayForSortMerge = { 71, 39, 28, 11, 55, 66, 59, 30, 98, 82 };;
        int[] arrayForMethodSort = arrayForSortMerge.clone();
        System.out.println("Неотсортированный массив: " + Arrays.toString(arrayForSortMerge));
        timeCheck = System.nanoTime();
        System.out.println("Массив отсортированный слиянием методом sortMerge(): "
                + Arrays.toString(sortMerge(arrayForSortMerge)));
        System.out.println("Время выполнения сортировки слиянием заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд");
        timeCheck = System.nanoTime();
        Arrays.sort(arrayForMethodSort);
        System.out.println("Массив отсортированный методом sort(): " + Arrays.toString(arrayForMethodSort));
        System.out.println("Время выполнения сортировки методом sort() заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\n");

        System.out.println("Задание 5.5");
        Random random = new Random();
        int[] arrayForBinarySearch = arrayForMethodSort.clone();
        int[] arrayForRecursionBinarySearch = arrayForMethodSort.clone();
        int key = arrayForMethodSort[random.nextInt(arrayForMethodSort.length)]; // рандомное число из массива для поиска
        timeCheck = System.nanoTime();
        System.out.println("Результат двоичного рекурсивного поиска: "
                + recursionBinarySearch(key, 0, arrayForRecursionBinarySearch.length, arrayForRecursionBinarySearch));
        System.out.println("Время выполнения рекурсивного двоичного поиска заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд");
        timeCheck = System.nanoTime();
        System.out.println("Результат обычного двоичного поиска: " + Arrays.binarySearch(arrayForBinarySearch, key));
        System.out.println("Время выполнения обычного двоичного поиска заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд");
    }

    private static int recursionMethod(int i) {
        System.out.println(i);
        return recursionMethod(++i);
    }

    private static int recursionMethodWithExit(int i) {
        System.out.print(i + " ");
        if (i >= 20) return i;
        return recursionMethodWithExit(++i);
    }

    private static void cyclicallyFillTheArray() {
        for (int i = 0; i < ARRAY_FOR_CYCLE.length; i++) {
            ARRAY_FOR_CYCLE[i] = i + 1;
        }
    }

    private static void recursivelyFillTheArray(int i) {
        ARRAY_FOR_RECURSION[value++] = i;
        if (value < ARRAY_FOR_RECURSION.length) {
            recursivelyFillTheArray(++i);
        }
    }

    private static int recursionBinarySearch(int key, int low, int high, int[] arr) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (arr[middle] == key) {
            return middle;
        } else if (arr[middle] < key) {
            return recursionBinarySearch(key, middle + 1, high, arr);
        } else {
            return recursionBinarySearch(key, low, middle - 1, arr);
        }
    }

    public static int[] sortMerge(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return arr;
        }
        int middle = length / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, length)));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}