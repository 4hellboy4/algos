//package trees;
//
//class RedBlackTree<K extends Comparable<K>, V> {
//    private static boolean RED = true;
//    private static boolean BLACK = false;
//
//    private Node<K, V> root;
//
//    private class Node<K, V> {
//        private K key;
//        private V value;
//        private Node<K, V> left;
//        private Node<K, V> right;
//        private boolean color;
//        private int size;
//
//        public Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            left = null;
//            right = null;
//            this.color = RED;
//            size = 1;
//        }
//    }
//
//    public boolean isRED(Node<K, V> node) {
//        if (node == null) {
//            return BLACK;
//        }
//        return node.color;
//    }
//
//    public void flipColors(Node<K, V> node) {
//        node.color = RED;
//        if (node.left != null) node.left.color = BLACK;
//        if (node.right != null) node.right.color = BLACK;
//    }
//
//    // TODO
//    public Node<K, V> rotateWithLeftChild(Node<K, V> node) {//leftChildRotation
//        Node<K, V> left = node.left;
//        Node<K, V> leftRight = left.right;
//        leftRight = node;
//        node.left = leftRight;
//        return left;
//    }
//
//    public Node<K, V> rotateWithRightChild(Node<K, V> node) {
//        Node<K, V> right = node.right;
//        Node<K, V> rightLeft = right.left;
//        rightLeft = node;
//        node.right = rightLeft;
//        return right;
//    }
//
//    public Node<K, V> doubleLeftChildRotation(Node<K, V> node) {
//        node.left = rotateWithRightChild(node.left);
//        return rotateWithLeftChild(node);
//    }
//
//    public Node<K, V> doubleRightChildRotation(Node<K, V> node) {
//        node.right = rotateWithLeftChild(node.right);
//        return rotateWithRightChild(node);
//    }
//
//    // TODO
//    public V get(K key) {
//        return get(root, key).value;
//    }
//
//    // TODO
//    private Node<K, V> get(Node<K, V> node, K key) {
//        if (node == null) {
//            return null;
//        }
//        int compareToKey = key.compareTo(node.key);
//        if (compareToKey < 0) {
//           return get(node.left, key);
//        } else if (compareToKey > 0) {
//            return get(node.right, key);
//        } else {
//            return node;
//        }
//    }
//
//    public void add(K key, V value) {
//        root = add(root, key, value);
//        root.color = BLACK;
//    }
//
//    private Node<K, V> add(Node<K, V> node, K key, V value) {
//        if (node == null) {
//            setSize(getSize() + 1);
//            return new Node<>(key, value);
//        }
//        int compareToKey = key.compareTo(node.key);
//        if (compareToKey < 0) {
//            node.left = add(node.left, key, value);
//        } else if (compareToKey > 0) {
//            node.right = add(node.right, key, value);
//        } else {
//            node.value = value;
//        }
//
//        if (isRED(node.left) && isRED(node.left.left)) {
//            node = rotateWithLeftChild(node);
//            node.color = BLACK;
//            node.right.color = RED;
//        }
//        if (isRED(node.left) && isRED(node.left.right)) {
//            node = doubleLeftChildRotation(node);
//            node.color = BLACK;
//            node.right.color = RED;
//        }
//        if (isRED(node.right) && isRED(node.right.right)) {
//            node = rotateWithRightChild(node);
//            node.color = BLACK;
//            node.left.color = RED;
//        }
//        if (isRED(node.right) && isRED(node.right.left)) {
//            node = doubleRightChildRotation(node);
//            node.color = BLACK;
//            node.left.color = RED;
//        }
//
//        return node;
//    }
//
//    public Node<K, V> findMinimum(Node<K,V> node) {
//        if (node == null) return null;
//        if (node.left == null) {
//            return node;
//        }
//        return findMinimum(node.left);
//    }
//
//    public Node<K, V> removeMin(Node<K, V> node) {
//        if (node == null) return null;
//        if (node.left == null) {
//            Node<K, V> right = node.right;
//            setSize(getSize()-1);
//            node.right = null;
//            return right;
//        }
//        node.left = removeMin(node.left);
//        setSize(getSize()-1);
//        return node.right;
//    }
//
//    public V remove(K key) { // why do we return a value when we delete a node
//        Node<K, V> node = get(root, key);
//        if (node!= null) {
//            root = remove(root, key);
//            return root.value;
//        }
//        return null;
//    }
//
//    private Node<K, V> remove(Node<K, V> node, K key) {
//        if (node == null) {
//            return null;
//        }
//        int compareToKey = key.compareTo(node.key);
//        if (compareToKey < 0) {
//            node.left = remove(node.left, key);
//            //return node;
//        } else if(compareToKey > 0) {
//            node.right = remove(node.right, key);
//            //return node;
//        } else {
//            if (node.left == null && node.right == null) {
//                node = null;
//            }
//            if (node.left == null) {
//                node = node.right;
//            }
//            if (node.right == null) {
//                node = node.left;
//            } else {
//
//            }
//
//
//
//            setSize(getSize() - 1);
//            return node;
//        }
//        return node;
//    }
//
//}
