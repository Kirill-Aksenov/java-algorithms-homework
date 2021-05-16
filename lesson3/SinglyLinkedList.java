package lesson3;

class Link<T> {
    private T link;
    private Link<T> next;

    public Link(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue() {
        return link;
    }
}

public class SinglyLinkedList<T> {
    private Link<T> first;

    public SinglyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(T link) {
        Link<T> l = new Link<>(link);
        l.setNext(first);
        this.first = l;
    }
    public void delete() {
        first = first.getNext();
    }

    public void display() {
        Link<T> current = first;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    public T find(T searchNode) {
        Link<T> findNote = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNote.getValue())) {
                return findNote.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}
