package com.vijay.study.medium.datastructures.bst;

public class HeightBST {

    public static int height(Node root) {
        if(null == root)
            return -1;
        final int hl = height(root.left);
        final int hr = height(root.right);
        return 1 + Math.max(hl, hr);
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
