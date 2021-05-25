package lesson8;

public class FirstHashTable {
    private Item[] hashArray;
    private int arraySize;
    private Item nonItem;

    public FirstHashTable(int size) {
        this.arraySize = size;
        hashArray = new Item[size];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.println(hashArray[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    public Item find(int key) {
        int hashValue = hashFunction(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return nonItem;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashValue = hashFunction(key);
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            ++hashValue;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return nonItem;
    }
}