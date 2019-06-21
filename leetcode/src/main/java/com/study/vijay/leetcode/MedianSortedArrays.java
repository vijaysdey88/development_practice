package com.study.vijay.leetcode;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        final int median = (int) (Math.ceil((nums1.length + nums2.length) / 2.0d)) - 1;

        int i =0, j=0, sortedIndex=0;
        double result = -1;

        while(i <= median || j <= median) {
            if(sortedIndex == median) {
                if(i >= nums1.length) {
                    result = nums2[j];
                    if(isEven) {
                        result = (result + nums2[++j]) / 2.0d;
                    }
                    break;
                }

                if(j >= nums2.length) {
                    result = nums1[i];
                    if(isEven) {
                        result = (result + nums1[++i]) / 2.0d;
                    }
                    break;
                }


                if(nums1[i] < nums2[j]) {
                    result = nums1[i];
                    i++;
                } else {
                    result = nums2[j];
                    j++;
                }

                if(isEven) {
                    if(i >= nums1.length)
                        result = (result + nums2[j]) / 2.0d;
                    else if(j >= nums2.length)
                        result = (result + nums1[i]) / 2.0d;
                    else
                        result = (result + Math.min(nums1[i], nums2[j])) / 2.0d;
                }

                break;
            } else {
                if(i >= nums1.length) {
                    j++;
                } else if(j >= nums2.length) {
                    i++;
                } else if(nums1[i] < nums2[j])
                    i++;
                else
                    j++;
            }
            sortedIndex++;
        }
        return result;
    }
}


