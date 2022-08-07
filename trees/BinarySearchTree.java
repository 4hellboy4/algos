package trees;

public class BinarySearchTree<T extends Comparable<? super T>> {

    Node<T> root;

    private class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        Node(T element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception("the tree is empty");
        }
        return findMin(root);
    }

    private T findMin(Node<T> node) {
        return node.left == null ? node.element : findMin(node.left);
    }

    public T findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception("the tree is empty");
        }
        return findMax(root);
    }

    private T findMax(Node<T> node) {
        return node.right == null ? node.element : findMax(node.right);
    }

    public boolean contains(T val) {
        return contains(root, val);
    }

    private boolean contains(Node<T> node, T val) {
        if (node == null) return false;
        int compareToVal = val.compareTo(node.element);
        if (compareToVal < 0) {
            return contains(node.left, val);
        } else if (compareToVal > 0) {
            return contains(node.right, val);
        } else {
            return true;
        }
    }

    public void insert(T val) {
        root = insert(root, val);
    }

    public Node<T> insert(Node<T> node, T val) {
        if (node == null) {
            return new Node<>(val);
        }
        int compareToVal = val.compareTo(node.element);
        if (compareToVal < 0) {
            node.left = insert(node.left, val);
        } else if (compareToVal > 0) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public void remove(T val) {
        root = remove(root, val);
    }

    private Node<T> remove(Node<T> node, T val) {
        if (node == null) return node;
        int compareToVal = val.compareTo(node.element);
        if (compareToVal < 0) {
            node.left = remove(node.left, val);
        } else if (compareToVal > 0) {
            node.right = remove(node.right, val);
        } else if (node.left != null && node.right != null) {
            T valRight = findMin(node.right);
            node.element = valRight;
            node.right = remove(node.right, valRight);
        } else if (node.left != null) {
            node.element = (node.left).element;
        } else if (node.right != null){
            node.element = (node.right).element;
        } else {
            node = null;
        }

        return node;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The tree is empty");
        } else {
            print(root);
        }
    }

    private void print(Node<T> node) {
        if (node == null) return;
        print(node.left);
        System.out.print(node.element + " ");
        print(node.right);
    }

}
