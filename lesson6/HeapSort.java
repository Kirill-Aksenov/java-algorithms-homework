package lesson6;

class HeapSort {
    private static int heapSize;

    public static void sort(int[] array) {
        buildHeap(array);
        while (heapSize > 1) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            heapify(array, 0);
        }
    }

    public static void buildHeap(int[] array) {
        heapSize = array.length;
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static void heapify(int[] array, int index) {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if (left < heapSize && array[index] < array[left]) {
            largest = left;
        }
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }
        if (index != largest) {
            swap(array, index, largest);
            heapify(array, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int firstIndex, int secondIndex) {
        int buffer = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = buffer;
    }
}