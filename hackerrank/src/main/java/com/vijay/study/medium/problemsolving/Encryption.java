package com.vijay.study.medium.problemsolving;

import java.util.List;

public class Encryption {


    public static String encryption(String input) {
        final char[] chars = input.replace(" ", "").toCharArray();
        final double sqrt = Math.sqrt(chars.length);
        int rows = (int)Math.floor(sqrt);
        int cols = (int)Math.ceil(Math.sqrt(chars.length));
        rows = (rows*cols) < chars.length ? rows+1 : rows;

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int idx = j + cols*i;
                if(idx < chars.length)
                    sb.append(chars[idx]);
            }
            if(j != cols - 1)
                sb.append(" ");
        }

        return sb.toString();
    }
}
