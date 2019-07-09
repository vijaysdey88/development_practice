package com.vijay.study.medium.datastructures.bst;

public class CheckBST {

    static boolean checkBST(Node root) {
        return checkBST(root, -1, Integer.MAX_VALUE);
    }

    static boolean checkBST(Node root, int min, int max) {
        if(null == root)
            return true;
        boolean b = root.data > min && root.data < max;
        if(!b)
            return false;
        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
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
