package lesson8;

public class SecondHashTable {
    private Item[] hashArray;
    private int arraySize;
    private Item nonItem;

    public SecondHashTable(int size) {
        this.arraySize = size;
        hashArray = new Item[arraySize];
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

    public int hashFunctionOne(int key) {
        return key % arraySize;
    }

    public int hashFunctionTwo(int key) {
        return 5 - key % 5;
    }

    public Item find(int key) {
        int hashValue = hashFunctionOne(key);
        int stepSize = hashFunctionTwo(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        return nonItem;
    }

    public void insert(Item item) {
        int key = item.getKey();
        int hashValue = hashFunctionOne(key);
        int stepSize = hashFunctionTwo(key);
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }

    public Item delete(int key) {
        int hashValue = hashFunctionOne(key);
        int stepSize = hashFunctionTwo(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                Item temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return temp;
            }
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        return nonItem;
    }
}