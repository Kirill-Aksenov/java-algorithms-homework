package lesson4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long timeCheck;

        System.out.print("Задание 4.1\nЗаполняем стек (Stack) через LinkedList: ");
        Integer[] array = { 11, 65, 85, 59, 41, 36, 7, 91, 14 };
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(array));
        Stack<Integer> stack = new Stack<>();
        timeCheck = System.nanoTime();
        stack.addAll(linkedList);
        System.out.println(stack + "\nВыводим последний элемент стека методом peek(): " + stack.peek());
        stack.pop();
        System.out.println("Удаляем последний элемент стека методом pop(): " + stack);
        System.out.println("Время выполнения данных операций заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");

        System.out.print("Задание 4.2\nЗаполняем очередь (Queue) через LinkedList: ");
        timeCheck = System.nanoTime();
        Queue<Integer> queue = new LinkedList<>(linkedList);
        System.out.println(queue + "\nВыводим первый элемент очереди с помощью метода element(): " + queue.element());
        queue.remove();
        System.out.println("Удаляем первый элемент очереди с помощью метода remove(): " + queue);
        System.out.println("Проверяем пуста ли очередь с помощью метода isEmpty: " + queue.isEmpty());
        System.out.println("Проверяем размер очереди с помощью метода size(): " + queue.size());
        System.out.println("Время выполнения данных операций заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");

        System.out.print("Задание 4.3\nЗаполняем дек (Deque) через LinkedList: ");
        timeCheck = System.nanoTime();
        Deque<Integer> deque = new LinkedList<>(linkedList);
        System.out.print(deque + "\nДобавляем элементы в начало и конец Deque с помощью методов addFirst() и addLast(): ");
        deque.addFirst(3);
        deque.addLast(99);
        System.out.println(deque);
        System.out.println("Выводим первый и последний элементы Deque с помощью методов peekFirst() и peekLast(): "
                + deque.peekFirst() + " и " + deque.peekLast());
        deque.pollFirst();
        deque.pollLast();
        System.out.println("Удаляем первый и последний элементы Deque с помощбю методов pollFirst() и pollLast(): " + deque);
        System.out.println("Время выполнения данных операций заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");

        System.out.print("Задание 4.4\nЗаполняем приоритетную очередь (PriorityQueue) через LinkedList: ");
        timeCheck = System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(linkedList);
        System.out.println(priorityQueue + "\nВыводим элемент с наивысшим приоритетом методом peek(): " + priorityQueue.peek());
        priorityQueue.poll();
        System.out.println("Удаляем элемент с наивысшим приоритетом методом peek() и выводим итоговую PriorityQueue: "
                + priorityQueue);
        System.out.println("Время выполнения данных операций заняло: " + (System.nanoTime() - timeCheck) + " наносекунд\n");

        System.out.print("Задание 4.5\nЗаполняем стек (Stack) на основе связанного списка (MyStack): ");
        MyStack myStack = new MyStack();
        timeCheck = System.nanoTime();
        for (Integer integer : stack) {
            myStack.push(integer);
        }
        myStack.display();
        System.out.print("\nПроверка порядка удаления элементов стека методом pop(): ");
        System.out.print("элементы ");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println(" удалены из стека\nВремя выполнения данных операций заняло: " + (System.nanoTime() - timeCheck)
                + " наносекунд\n");
        System.out.print("Заполняем очередь (Queue) на основе связанного списка (MyQueue): ");
        MyQueue myQueue = new MyQueue();
        timeCheck = System.nanoTime();
        for (int i = 0; i < queue.size();) {
            myQueue.insert(queue.peek());
            queue.poll();
        }
        myQueue.display();
        System.out.print("\nУдаляем элементы один за другим, пока очередь не станет пустой: ");
        System.out.print("элементы ");
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.delete() + " ");
        }
        System.out.println(" удалены из очереди (MyQueue)\nВремя выполнения данных операций заняло: "
                + (System.nanoTime() - timeCheck) + " наносекунд\n");
    }

    static class Link {
        public int value;

        public Link next;

        public Link(int value) {
            this.value = value;
        }

        public void display() {
            System.out.print(this.value + " ");
        }
    }

    static class MyLinkedList {
        public Link first;

        public MyLinkedList() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(int value) {
            Link newLink = new Link(value);
            newLink.next = first;
            first = newLink;
        }

        public Link delete() {
            Link temp = first;
            first = first.next;
            return temp;
        }

        public void display() {
            Link current = first;
            while (current != null) {
                current.display();
                current = current.next;
            }
        }
    }

    static class MyStack {
        private MyLinkedList list;

        public MyStack() {
            list = new MyLinkedList();
        }

        public void push(int value) {
            list.insert(value);
        }

        public int pop() {
            return list.delete().value;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }

    static class MyQueue {
        private MyLinkedList myQueue;

        public MyQueue() {
            myQueue = new MyLinkedList();
        }

        public void insert(int value) {
            myQueue.insert(value);
        }

        public int delete() {
            return myQueue.delete().value;
        }

        public boolean isEmpty() {
            return myQueue.isEmpty();
        }

        public void display() {
            myQueue.display();
        }
    }
}