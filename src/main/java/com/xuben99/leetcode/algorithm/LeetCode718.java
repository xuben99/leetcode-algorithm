package com.xuben99.leetcode.algorithm;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class LeetCode718 {
    public int findLength(int[] A, int[] B) {
        int [][]dp = new int[A.length][B.length];
        int max = 0;
        for(int i = 0; i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                if (A[i]==B[j]){
                    if(i-1>=0 && j-1>=0 &&  A[i-1] == B[j-1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        dp[i][j] = 1;

                    }
                    }else {
                    dp[i][j] = 0;
                }
                if (dp[i][j]>max) max =dp[i][j];
                }
            }



        return max;
    }

    public static void main(String[] args) {
        int[] num1 = {0,0,0,0,1};

        int[] num2 = {1,0,0,0,0};


        System.out.println(new LeetCode718().findLength(num1, num2));


    }
}