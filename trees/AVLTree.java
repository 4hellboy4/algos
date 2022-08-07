package trees;

class AVLTree<T extends Comparable<? super T>>{

    private final int CONST_HEIGHT = 1;

    Node<T> root;

    public AVLTree() {
        root = null;
    }

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        int height;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(T element, Node<T> left, Node<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 1;
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

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void updateSize(Node<T> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node<T> rotateRightChild(Node<T> node) {
        Node<T> right = node.right;
        Node<T> rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;
        updateSize(node);
        updateSize(right);
        return right;
    }

    private Node<T> doubleRotationWithRightChild(Node<T> node) {
        node.right = rotateLeftChild(node.right);
        return rotateRightChild(node);
    }

    private Node<T> rotateLeftChild(Node<T> node) {
        Node<T> left = node.left;
        Node<T> leftRight = left.right;
        left.right = node;
        node.left = leftRight;
        updateSize(node);
        updateSize(left);
        return left;
    }

    public void whoIsRoot() {
        System.out.println(root.element);
    }

    private Node<T> doubleRotationWithLeftChild(Node<T> node) {
        node.left = rotateRightChild(node.left);
        return rotateLeftChild(node);
    }

    private Node<T> balance(Node<T> node) {
        if (node == null) return null;
        if (height(node.left) - height(node.right) > CONST_HEIGHT) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = doubleRotationWithRightChild(node);
            } else {
                node = doubleRotationWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > CONST_HEIGHT) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeftChild(node);
            } else {
                node = rotateRightChild(node);
            }
        }
        return node;
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
        return balance(node);
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
        return balance(node);
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
