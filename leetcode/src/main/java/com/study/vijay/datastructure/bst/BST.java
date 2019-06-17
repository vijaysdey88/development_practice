package com.study.vijay.datastructure.bst;

public class BST<K extends Comparable, V> {

    private Node<K,V> root;

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> node, K key, V val) {
        if(null == node)
            return new Node<>(key, val);
        int c =  key.compareTo(node.key);
        if(c < 0) {
            node.left = put(node.left, key, val);
        } else if(c > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    public V get(K key) {
        final Node<K, V> n = get(root, key);
        return n != null ? n.val : null ;
    }

    private Node<K,V> get(Node<K, V> node, K key) {
        if(null == node)
            return null;
        int c =  key.compareTo(node.key);
        if(c < 0) {
            return get(node.left, key);
        } else if(c > 0) {
            return get(node.right, key);
        }
        return node;
    }

    private static final class Node<K, V> {
        final K key;
        V val;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
