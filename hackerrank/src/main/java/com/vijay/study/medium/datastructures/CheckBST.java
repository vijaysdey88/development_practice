package com.vijay.study.medium.datastructures;

public class CheckBST {

    static boolean checkBST(Node root) {
        if(null == root)
            return true;
        final boolean isValidBSTNode = (null == root.left || root.data > root.left.data) && (null == root.right || root.data < root.right.data);
        if(!isValidBSTNode)
            return false;
        return checkBST(root.left) && checkBST(root.right);
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
