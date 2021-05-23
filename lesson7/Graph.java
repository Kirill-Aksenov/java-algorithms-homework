package lesson7;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTICES = 32;
    private final Vertex[] vertexList;
    private final int[][] adjacencyMatrix;
    private int vertexCounter;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        vertexCounter = 0;

        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[vertexCounter++] = new Vertex(label);
    }

    public void addEdge(int initialVertex, int finalVertex) {
        adjacencyMatrix[initialVertex][finalVertex] = 1;
        adjacencyMatrix[finalVertex][initialVertex] = 1;
    }

    public void displayVertex(int vertexNumber) {
        System.out.println(vertexList[vertexNumber].label);
    }

    public void displayEdge(int initialVertex, int adjacentVertex) {
        System.out.println("вершины: " + vertexList[initialVertex].label + "-" + vertexList[adjacentVertex].label);
    }

    public int checksVertexAdjacency(int vertexNumber) {
        for (int i = 0; i < vertexCounter; i++) {
            if (adjacencyMatrix[vertexNumber][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    // в методе depthFirstSearch принимаемый параметр resetFlags нужен для сбрасывания флагов
    // если мы планируем использовать метод не единожды, то его значение нужно указывать как true
    // в противном случае повторное применение метода не даст никакого результата
    public void depthFirstSearch(int initialVertex, boolean resetFlags) {
        vertexList[initialVertex].wasVisited = true;
        for (int i = 0; i < vertexCounter; i++) {
            int adjacentVertex = checksVertexAdjacency(initialVertex);
            if (!vertexList[i].wasVisited && adjacentVertex != -1 && i == adjacentVertex) {
                displayEdge(initialVertex, adjacentVertex);
                depthFirstSearch(i, false);
            }
        }
        if(resetFlags) {
            for (int i = 0; i < vertexCounter; i++) {
                vertexList[i].wasVisited = false;
            }
        }
    }

    public void breadthFirstSearch(int initialVertex) {
        int[] queue = new int[vertexCounter];
        int queueStart = 0;
        int queueEnd = 0;
        vertexList[initialVertex].wasVisited = true;
        queue[queueEnd++] = initialVertex;
        int adjacentVertex;
        while (queueStart < queueEnd) {
            initialVertex = queue[queueStart++];
            for (int i = 0; i < vertexCounter; i++) {
                adjacentVertex = checksVertexAdjacency(initialVertex);
                if (adjacentVertex != -1 && !vertexList[adjacentVertex].wasVisited) {
                    vertexList[adjacentVertex].wasVisited = true;
                    displayEdge(initialVertex, adjacentVertex);
                    queue[queueEnd++] = adjacentVertex;
                }
            }
        }
        for (int i = 0; i < vertexCounter; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}