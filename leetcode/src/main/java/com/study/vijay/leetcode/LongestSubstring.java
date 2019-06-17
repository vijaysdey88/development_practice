package com.study.vijay.leetcode;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;

        int start = 0;
        int cnt = 1;
        int maxCnt = 1;

        int i = 1;
        while (i < s.length()) {
            final char current = s.charAt(i);
            final String preceding = s.substring(start, i);
            if(!preceding.contains(current + "")) {
                cnt++;
                i++;
            }
            else {
                if(cnt > maxCnt) {
                    maxCnt = cnt;
                }
                start++;
                cnt  = 1;
                i = start + 1;
            }
        }
        return Math.max(maxCnt, cnt);
    }
}
