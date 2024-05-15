public class Testing {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(43);
        avlTree.insert(65);
        avlTree.insert(33);
        avlTree.insert(12);
        avlTree.insert(47);
        avlTree.insert(78);
        avlTree.printTree();
    }
}
