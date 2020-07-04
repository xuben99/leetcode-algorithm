package com.xuben99.leetcode.algorithm;

import java.util.*;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res[] = new double[nums1.length+nums2.length];

        for (int i =0;i<nums1.length;i++){
            res[i] = nums1[i];
        }
        for (int i =0;i<nums2.length;i++){
            res[nums1.length + i] = nums2[i];

        }
//
//
//        Set<Integer> set = new HashSet();
//        for (int i :nums){
//            set.add(i);
//        }
//        double []res = new double[set.size()];
//        int index =0;
//        for (Integer i:set){
//            res[index++] = i;
//        }
        Arrays.sort(res);
        int mid =res.length/2;

        return res.length%2==0?(res[mid-1]+res[mid])/2: res[mid];

    }

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};


        System.out.println(new LeetCode4().findMedianSortedArrays(num1, num2));


    }
}