public class Node<T extends Comparable<T>> {
    private T value;
    private int height;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        this.height = 1;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void updateHeight() {
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        this.height = 1 + Math.max(leftHeight, rightHeight);
    }

    public int balanceFactor() {
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        return leftHeight - rightHeight;
    }
}
