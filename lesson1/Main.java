package lesson1;

public class Main {

    private final int number;
    private static long timeCheck;

    Main(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean comparesData(int[] data) {
        timeCheck = System.nanoTime();
        int comparable = 41;
        for (int comparedData : data) {
            if (comparable == comparedData) {
                System.out.println("Переменная " + comparable + " обнаружена при сравнении данных");
                return true;
            }
        }
        System.out.println("Переменная " + comparable + " не обнаружена при сравнении данных");
        return false;
    }

    public static void main(String[] args) {
        int primitiveDataType = 23;     // примитивный тип данных
        Integer referenceDataType = 41; // ссылочный тип данных
        Main main = new Main(6); // тип данных класса Main

        int[] data = {primitiveDataType, referenceDataType, main.getNumber()};

        System.out.println("Примитивный тип данных имеет значение: " + primitiveDataType);
        System.out.println("Ссылочный тип данных имеет значение: " + referenceDataType);
        System.out.println("Ссылочный тип данных класса Main имеет значение: " + main.getNumber());

        comparesData(data); // метод сравнивает значение переменной comparable со значениями наших типов данных

        System.out.println(("Время выполнения алгоритма по сравнению данных заняло: " +
                (System.nanoTime() - timeCheck) + " наносекунд"));
    }
}