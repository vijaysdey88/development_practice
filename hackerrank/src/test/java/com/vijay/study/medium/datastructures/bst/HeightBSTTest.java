package com.vijay.study.medium.datastructures.bst;

import com.vijay.study.medium.datastructures.bst.HeightBST;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.vijay.study.medium.datastructures.bst.HeightBST.*;
import static org.junit.Assert.*;

public class HeightBSTTest {




    @Test
    public void heightOfTwoNodeTreeWithNullRightNode(){
        verifyHt(new Node(2, new Node(1), null), 1);
    }

    @Test
    public void height3NodeTreeShouldBeOne(){
        verifyHt(new Node(2, new Node(1), new Node(3)), 1);
    }

    @Test
    public void heightOfTwoNodeTreeWithNullLefttNode(){
        verifyHt(new Node(2, null, new Node(1)), 1);
    }


    @Test
    public void height4NodeTreeShouldBeOne(){
        verifyHt(new Node(2, new Node(1), new Node(3)), 1);
    }

    @Test
    public void height5NodeTreeShouldBe2(){
        verifyHt(new Node(5, new Node(1, null, null), new Node(8, null, new Node(9))), 2);
    }


    private void verifyHt(Node root, int operand) {
        assertThat(HeightBST.height(root), Matchers.equalTo(operand));
    }
}