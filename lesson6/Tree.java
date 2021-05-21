package lesson6;

class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("id: " + person.id + ", имя: " + person.name + ", возраст: " + person.age);
    }
}

class Tree {
    private Node root;

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private void directTraversal(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            directTraversal(rootNode.leftChild);
            directTraversal(rootNode.rightChild);
        }
    }

    private void reverseTraversal(Node rootNode) {
        if (rootNode != null) {
            reverseTraversal(rootNode.leftChild);
            reverseTraversal(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void symmetricTraversal(Node rootNode) {
        if (rootNode != null) {
            symmetricTraversal(rootNode.leftChild);
            rootNode.display();
            symmetricTraversal(rootNode.rightChild);
        }
    }

    public void displayTree() {
        Node current = root;
        System.out.println("\nВывод дерева через прямой обход:");
        directTraversal(root);
        System.out.println("\nВывод дерева через обратный обход:");
        reverseTraversal(current);
        System.out.println("\nВывод дерева через симметричный обход:");
        symmetricTraversal(root);
    }

    public Node findMin() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }
}