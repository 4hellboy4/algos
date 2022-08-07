//package trees;
//
//import java.util.*;
//
//class CartesianTree {
//
//    private Node root;
//
//    private static class Node {
//        int key;
//        int priority;
//        int size;
//        Node left;
//        Node right;
//
//        Node(int key) {
//            this.key = key;
//            this.priority = new Random().nextInt();
//            this.size = 1;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    private int getSize(Node node) {
//        if (node == null) {
//            return 0;
//        } else {
//            return node.size;
//        }
//    }
//
//    private void updateSize(Node node) {
//        if (node == null) return;
//        node.size = getSize(node.left) + 1 + getSize(node.right);
//    }
//
//    private Node merge(Node left, Node right) {
//        if (left == null) return right;
//        if (right == null) return left;
//        if (left.priority < right.priority) {
//            right.left = merge(left, right.left);
//            updateSize(right);
//            return right;
//        } else {
//            left.right = merge(left.right, right);
//            updateSize(left);
//            return left;
//        }
//    }
//
//    private Node[] split(Node node, int key) {
//        if (node == null) return new Node[]{null, null, null};
//        if (node.key == key) {
//            Node left = node.left;
//            Node right = node.right;
//            node.left = node.right = null;
//            updateSize(node);
//            return new Node[]{left, node, right};
//        } else if (node.key > key) {
//
//        } else {
//
//        }
//    }
//
//
//}
