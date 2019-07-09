package com.vijay.study.medium.datastructures.bst;

import com.vijay.study.medium.datastructures.bst.DFSTraversal.Node;
import org.junit.Test;

public class DFSTraversalTest {

    //              4
    //      2               6
    //  1       3       5      7
    //0

    final Node root = new Node(4, new Node(2, new Node(1, new Node(0), null), new Node(3)), new Node(6, new Node(5), new Node(7)));

    @Test
    public void shouldPrintInPreOrder(){
        DFSTraversal.preOrder(root); //4 2 1 0 6 5 7
    }

    @Test
    public void shouldPrintInPostOrder(){
        DFSTraversal.postOrder(root); //0 1 3 2 5 7 6 4
    }

    @Test
    public void shouldPrintInOrder(){
        DFSTraversal.inOrder(root); //0 1 2 3 4 5 6 7
    }

    @Test
    public void topView(){
        DFSTraversal.topView(root); //0 1 2 4 6 7
        System.out.println();
        DFSTraversal.topView(root.right); //5 6 7
        System.out.println();
        DFSTraversal.topView(root.left); //0 1 2 3
    }

}