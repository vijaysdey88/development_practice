package com.vijay.study.medium.problemsolving;

//https://www.hackerrank.com/challenges/the-grid-search/problem
public class GridSearch {

    // Complete the gridSearch function below.
    static String gridSearch(String[] grid, String[] search) {
        final int searchRows = search.length;
        final int searchCols = search[0].length();
        final String searchString = convertString(search, 0, 0, searchRows, searchCols);


        for (int i = 0; i <= grid.length - search.length; i++) {
            for (int j = 0; j <= grid[0].length() - searchCols; j++) {
                if(charAt(grid, i, j) == charAt(search, 0, 0)
                  && charAt(grid, i, j + searchCols - 1) == charAt(search, 0, searchCols - 1)
                  && charAt(grid, i + searchRows - 1, j) == charAt(search, searchRows - 1, 0)
                  && charAt(grid, i + searchRows - 1, j + searchCols - 1) == charAt(search, searchRows - 1, searchCols - 1)
                  ) {
                    final String inputGridString = convertString(grid, i, j, searchRows, searchCols);
                    if(inputGridString.equals(searchString))
                        return "YES";
                }
            }
        }
        return "NO";
    }


    public static String convertString(String[] g, int i, int j, int rows, int cols) {
        final StringBuilder sb = new StringBuilder();
        for (int k = i; k < rows+i; k++) {
            for (int l = j; l < cols+j; l++) {
                sb.append(charAt(g, k, l));
            }
        }
        return sb.toString();
    }

    private static char charAt(String[] grid, int i, int j) {
        return grid[i].charAt(j);
    }
}
