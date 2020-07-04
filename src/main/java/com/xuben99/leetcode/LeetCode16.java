package com.xuben99.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class  LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int min = res;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                res = nums[i] + nums[low] + nums[high];

                if (Math.abs(res - target)<Math.abs(min-target)) {
                    min =res;
                }
                    if(res>target){
                        high--;
                    }else if(res< target){
                        low++;
                    }else {
                        return res;
                    }




            }


        }
        return min;
    }


    public static void main(String[] args) {
        int []arr = {0,2,1,-3};
        int target = 1;
        System.out.println(new LeetCode16().threeSumClosest(arr, target));
    }
}
