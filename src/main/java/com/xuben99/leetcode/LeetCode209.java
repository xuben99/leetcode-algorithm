package com.xuben99.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <=0 )return 0;
        int min = Integer.MAX_VALUE, low = 0, high = 0;
        int sum = nums[0];
        while (high < nums.length) {
            if (sum >= s) {
                if (min > high - low + 1) min = high - low + 1;
                sum -= nums[low++];
            } else {
                if (++high < nums.length) sum += nums[high];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] num = {};
        int s = 100;

        System.out.println(new LeetCode209().minSubArrayLen(s, num));


    }
}