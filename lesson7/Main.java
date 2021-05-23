package lesson7;

public class Main {

    public static void main(String[] args) {
        long timeCheck;

        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addEdge(0, 1); // A-B
        graph.addEdge(1, 2); // B-C
        graph.addEdge(2, 3); // C-D
        graph.addEdge(3, 4); // D-E
        graph.addEdge(0, 5); // A-F
        graph.addEdge(5, 6); // F-G
        graph.addEdge(0, 7); // A-H
        System.out.print("Задание 7.2\nСоздадим граф и выведем для примера несколько его вершин\nвершина под индексом 0: ");
        graph.displayVertex(0);
        System.out.print("вершина под индексом 7: ");
        graph.displayVertex(7);

        System.out.println("\nЗадание 7.3\nРезультат метода по обходу графа в глубину, начиная с вершины A:");
        timeCheck = System.nanoTime();
        graph.depthFirstSearch(0, true);
        System.out.println("Время данного обхода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");
        System.out.println("Результат метода по обходу графа в глубину, начиная с вершины C:");
        graph.depthFirstSearch(2, true);
        System.out.println("Время данного обхода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");

        System.out.println("Задание 7.4\nРезультат метода по обходу графа в ширину, начиная с вершины A:");
        timeCheck = System.nanoTime();
        graph.breadthFirstSearch(0);
        System.out.println("Время данного обхода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");
        System.out.println("Результат метода по обходу графа в ширину, начиная с вершины C:");
        graph.breadthFirstSearch(2);
        System.out.println("Время данного обхода заняло: " + (System.nanoTime() - timeCheck) + " наносекунд");
    }
}