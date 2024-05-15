public class AvlTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compareResult > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            return node;
        }
        node.updateHeight();
        return balance(node);
    }

    private Node<T> balance(Node<T> node) {
        int balanceFactor = node.balanceFactor();

        if (balanceFactor > 1) {
            if (node.getLeft().balanceFactor() < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balanceFactor < -1) {
            if (node.getRight().balanceFactor() > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.updateHeight();
        x.updateHeight();
        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.getRight();
        Node<T> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.updateHeight();
        y.updateHeight();
        return y;
    }

    public Node<T> find(T value) {
        Node<T> current = root;
        while (current != null) {
            int compareResult = value.compareTo(current.getValue());
            if (compareResult < 0) {
                current = current.getLeft();
            } else if (compareResult > 0) {
                current = current.getRight();
            } else {
                return current;
            }
        }
        return null;
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (compareResult > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node<T> temp = findMinNode(node.getRight());
                node.setValue(temp.getValue());
                node.setRight(delete(node.getRight(), temp.getValue()));
            }
        }
        node.updateHeight();
        return balance(node);
    }

    private Node<T> findMinNode(Node<T> node) {
        Node<T> current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("The tree is empty.");
        } else {
            printTree(root, "", true);
        }
    }

    private void printTree(Node<T> node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            System.out.println(node.getValue());
            printTree(node.getLeft(), indent, false);
            printTree(node.getRight(), indent, true);
        }
    }
}

