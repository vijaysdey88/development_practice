package com.study.vijay.amcat;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.min;

public class BSTProblem {

    private static final class BST<K extends Comparable> {
        Node<K> root;

        public void insert(K val) {
            root = insert(root, val);
        }

        private Node<K> insert(Node<K> node, K val) {
            if(null == node)
                return new Node<>(val);
            final int c = val.compareTo(node.value);
            if(c < 0)
                node.left = insert(node.left, val);
            else if(c > 0) {
                node.right = insert(node.right, val);
            }
            return node;
        }

        @Override
        public String toString() {
            return "BST{" +
                    "root=" + root +
                    '}';
        }

        public Stack<Node<K>> trace(K val) {
            Stack<Node<K>> trace = new Stack<>();
            Node<K> node = root;
            trace.push(root);

            while(null != node) {
                final int c = val.compareTo(node.value);
                if(c < 0){
                    node = node.left;
                } else if(c > 0) {
                    node = node.right;
                } else {
                   // System.out.println("Match node =" + node + " stack=" + trace);
                    break;
                }
                trace.push(node);
            }
           // System.out.println("Get Trace value =" + val + ", stack=" + trace + ", lastNode" + node);
            return trace;
        }

        public int findDistance(K node1, K node2) {
            //Choose smaller as node1 and bigger as node 2 to simply back traversal to second node
            if(node1.compareTo(node2) > 0) {
                K tmp = node1;
                node1 = node2;
                node2 = tmp;
            }
            //Search for node1, dumping its parents to a stack, if node is not found then top of stack will be null entry
            //This trace will help to traverse back to next node
            Stack<Node<K>> trace = trace(node1);
            //Dont bother if first node is not found
            if(trace.peek() == null)
                return -1;
            //0 distance if the nodes are same
            if(node1.equals(node2))
                return 0;

            int distance = 0;
            //Try to find the common parent between the nodes
            //Pop first element which is the node1 itself
            Node<K> commonParent = trace.pop();
            while(!trace.empty()) {
                commonParent = trace.pop();
                int c = commonParent.value.compareTo(node2);
                if(c > 0) {
                    commonParent = commonParent.left;
                    break;
                }
                if(c == 0) {
                    distance++;
                    break;
                }
                distance++;
            }


           // System.out.println("Common Parent = " + commonParent);
            if(commonParent.value.equals(node2)) {
                return distance;
            }


            //Traverse to the node2 computing the distance
            Node<K> search2 = commonParent.right;
            while(null != search2) {
                distance++;
                int c = search2.value.compareTo(node2);
                if(c < 0) {
                    search2 = search2.right;
                } else if(c > 0) {
                    //Traversed beyond node2 without finding it
                    return -1;
                } else {
                    break;
                }
            }
            if(null == search2)
                return -1;

            return distance;
        }
    }

    private static class Node<K extends Comparable> {
        K value;
        Node<K> left;
        Node<K> right;

        public Node(K value) {
            this.value = value;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    ", left=" + left +
//                    ", right=" + right +
//                    '}';
//        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        final Integer[] inputs = {5, 6, 3, 1, 2, 4};
        final Integer node1 = 2;
        final Integer node2 = 4;

        final BST<Integer> bst = new BST();
        Arrays.stream(inputs)
                .forEach(bst::insert);
      //  System.out.println(bst);

       // bst.trace(node1);
       // bst.trace(6);
       // bst.trace(7);

        testDist(bst, 4, 2);
        testDist(bst, 2, 4);
        testDist(bst,6, 2);
        testDist(bst,7, 2);
        testDist(bst,3, 2);
        testDist(bst,3, 2);
        testDist(bst,3, 6);

    }

    private static void testDist(BST<Integer> bst, Integer node1, Integer node2) {
        System.out.println("Distance("+node1+","+node2+") = " + bst.findDistance(node1, node2) );
    }
}
