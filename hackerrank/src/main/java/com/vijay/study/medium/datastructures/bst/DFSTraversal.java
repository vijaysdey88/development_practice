package com.vijay.study.medium.datastructures.bst;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    public static void levelOrder(Node root) {
        if(null == root)
            return;
        final Queue<Node> elements = new LinkedList<>();
        elements.add(root);

        while(!elements.isEmpty()) {
            final Node current = elements.remove();
            consume(current);
            enqueueIfPresent(elements, current.left);
            enqueueIfPresent(elements, current.right);
        }

    }

    public static Node insert(Node root,int data) {
        if(null == root) {
            final Node node = new Node();
            node.data = data;
            return node;
        }

        int c = root.data - data;
        if(c == 0) {
            root.data = data;
        } else if(c > 0) {
             root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    private static void enqueueIfPresent(Queue<Node> elements, Node node) {
        if (null != node)
            elements.add(node);
    }

    public static void topView(Node root) {
        if(null == root)
            return;
        final Map<Integer, Node> orderToNodes = new TreeMap<>();
        final Queue<OrderNode> elements = new LinkedList<>();
        elements.add(new OrderNode(root, 0));

        while (!elements.isEmpty()) {
            final OrderNode n = elements.remove();
            final int order = n.order;
            final Node node = n.node;
            orderToNodes.putIfAbsent(order, node);
            if(null != node.left)
                elements.add(new OrderNode(node.left, order - 1));
            if(null != node.right)
                elements.add(new OrderNode(node.right, order + 1));
        }

        final String result = orderToNodes.values()
                .stream()
                .map(n -> Integer.toString(n.data))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void consume(Node node) {
        System.out.print(node.data + " ");
    }


    private static class OrderNode {
        final Node node;
        final int order;

        public OrderNode(Node node, int order) {
            this.node = node;
            this.order = order;
        }

        @Override
        public String toString() {
            return "OrderNode{" +
                    "node=" + node +
                    ", order=" + order +
                    '}';
        }
    }

    public static class Node {
        int data;
        Node left;

        public Node() {
        }

        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
