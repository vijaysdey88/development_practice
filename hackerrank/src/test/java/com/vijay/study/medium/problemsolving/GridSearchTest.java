package com.vijay.study.medium.problemsolving;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridSearchTest {

    @Test
    public void testConvertSubGridToString(){
        String[] grid = {"012",
                         "345",
                         "678"};

        Assert.assertEquals("0134", GridSearch.convertString(grid, 0, 0, 2, 2));
        Assert.assertEquals("012345", GridSearch.convertString(grid, 0, 0, 2, 3));
        Assert.assertEquals("013467", GridSearch.convertString(grid, 0, 0, 3, 2));
        Assert.assertEquals("1245", GridSearch.convertString(grid, 0, 1, 2, 2));
        Assert.assertEquals("3467", GridSearch.convertString(grid, 1, 0, 2, 2));
        Assert.assertEquals("345678", GridSearch.convertString(grid, 1, 0, 2, 3));
    }

    @Test
    public void shouldDetectTheSearchInGridAtTopLeft(){
        String[] grid = {"012",
                         "345",
                         "678"};
        String[] search1 = {"01",
                            "34"};
        Assert.assertEquals("YES", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldDetectTheSearchInGridAtTopRight(){
        String[] grid = {"012",
                         "345",
                         "678"};
        String[] search1 = {"12",
                            "45"};
        Assert.assertEquals("YES", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldDetectTheSearchInGridAtBottomLeft(){
        String[] grid = {"012",
                         "345",
                         "678"};
        String[] search1 = {"34",
                            "67"};
        Assert.assertEquals("YES", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldDetectTheSearchInGridAtBottomRight(){
        String[] grid = {"012",
                         "345",
                         "678"};
        String[] search1 = {"45",
                            "78"};
        Assert.assertEquals("YES", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldDetectTheSearchInWhenSearchIsNotSquare(){
        String[] grid = {"012",
                         "345",
                         "678"};
        String[] search1 = {"345",
                            "678"};
        Assert.assertEquals("YES", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldNotDetectTheSearchInGridWhenTopRowDoesntMatchByOneElement(){
        String[] grid = {"012",
                         "345",
                         "678"};

        String[] search1 = {"02",
                            "34"};

        Assert.assertEquals("NO", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldNotDetectTheSearchInGridWhenTopRowDoesntMatch(){
        String[] grid = {"012",
                         "345",
                         "678"};

        String[] search1 = {"12",
                            "34"};

        Assert.assertEquals("NO", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldNotDetectTheSearchInGridWhenBottomRowDoesntMatch(){
        String[] grid = {"012",
                        "345",
                        "678"};

        String[] search1 = {"01",
                            "35"};

        Assert.assertEquals("NO", GridSearch.gridSearch(grid, search1));
    }

    @Test
    public void shouldNotDetectTheSearchInGridWhenMiddleRowDoesntMatch(){
        String[] grid = {"012",
                        "345",
                        "678"};

        String[] search1 = {"01",
                            "35",
                            "67"};

        Assert.assertEquals("NO", GridSearch.gridSearch(grid, search1));
    }


//    @Test
//    public void shouldIndicateMaybePresent(){
//        int[][] grid = {{0, 1, 2, 3},
//                        {4, 5, 5, 6},
//                        {7, 8, 9, 10},
//                        {11, 12, 13, 14}};
//        int[][] search1 = {{0, 1},
//                          {4, 5}};
//        Assert.assertTrue(GridSearch.maybePresent(grid, search1));
//
//    }
//
//    @Test
//    public void shouldIndicateAbsolutelyNotPresent(){
//        int[][] grid = {{0, 1, 2, 3},
//                        {4, 5, 5, 6},
//                        {7, 8, 9, 10},
//                        {11, 12, 13, 14}};
//        int[][] search = {{0, 1},
//                          {4, 5}};
//
//        Assert.assertFalse(GridSearch.maybePresent(grid, search));
//    }

}