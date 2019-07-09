package com.vijay.study.medium.datastructures.bst;

import com.vijay.study.medium.datastructures.bst.CheckBST;
import com.vijay.study.medium.datastructures.bst.CheckBST.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckBSTTest {

    @Test
    public void shouldBeABstFor3NodesTree(){
        final Node root = new Node(2, new Node(1), new Node(3));

        assertTrue(CheckBST.checkBST(root));
    }

    @Test
    public void shouldReturnFalseIfLeftNodeIsGreaterThanRootFor3NodeTree(){
        assertFalse("Left node is greater than root", CheckBST.checkBST(new Node(2, new Node(3), new Node(4))));
        assertFalse("Left node is equal to root", CheckBST.checkBST(new Node(2, new Node(2), new Node(4))));
    }

    @Test
    public void shouldReturnFalseIfRightNodeIsEqualOrSmallerThanRootFor3NodeTree(){
        assertFalse("Right node is smaller than root", CheckBST.checkBST(new Node(2, new Node(0), new Node(1))));
        assertFalse("Right node is equal to root", CheckBST.checkBST(new Node(2, new Node(1), new Node(2))));
    }

    @Test
    public void shouldReturnFalseIfLeftNodeIsGreaterThanRootFor4NodeTreeInLeftSubtree(){
        final Node root1 = new Node(4, new Node(2, new Node(3), null), new Node(5));

        assertFalse("Left node is greater than root at level 3", CheckBST.checkBST(root1));

    }

    @Test
    public void shouldReturnFalseIfRightNodeIsLessThanRootFor4NodeTreeInLeftSubtree(){
        final Node root = new Node(4, new Node(2, null, new Node(1)), new Node(5));

        assertFalse("Left node is greater than root at level 3", CheckBST.checkBST(root));
    }

    @Test
    public void shouldReturnFalseIfLeftNodeIsGreaterThanRootFor4NodeTreeInRightSubtree(){
        final Node root = new Node(2, new Node(1), new Node(5, new Node(6), null));

        assertFalse("Left node is greater than root at level 3", CheckBST.checkBST(root));
    }
    
    @Test
    public void testWhenGrandchildNodeHasSameValueOfRoot(){
        final Node root = new Node(4, new Node(1, new Node(0), new Node(4)), null);
        assertFalse("Child of child node has same value as root ", CheckBST.checkBST(root));
    }

    @Test
    public void testForNullInput(){
        assertTrue(CheckBST.checkBST(null));
    }

}