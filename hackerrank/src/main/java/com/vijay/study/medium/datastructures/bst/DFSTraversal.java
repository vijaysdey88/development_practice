package com.vijay.study.medium.datastructures.bst;

public class DFSTraversal {

    public static void preOrder(Node root) {
        if(null == root)
            return;
        consume(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(null == root)
            return;
        postOrder(root.left);
        postOrder(root.right);
        consume(root);
    }

    public static void inOrder(Node root) {
        if(null == root)
            return;
        inOrder(root.left);
        consume(root);
        inOrder(root.right);
    }

    public static void topView(Node root) {
       topView(root, true, true);
    }

    private static void topView(Node node, boolean consumeLeft, boolean consumeRight) {
        if(null == node)
            return;
        if(consumeLeft) {
            topView(node.left, true, false);
        }
        consume(node);
        if(consumeRight) {
            topView(node.right, false, true);
        }
    }

    private static void consume(Node node) {
        System.out.print(node.data + " ");
    }


    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
