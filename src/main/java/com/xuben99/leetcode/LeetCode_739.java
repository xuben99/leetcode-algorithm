package com.xuben99.leetcode;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class LeetCode_739 {

    public int[] dailyTemperatures(int[] T) {


        for(int i =0;i<T.length-1;i++){
            int flag = 0;
            boolean isLarge =false;
            for (int j=i+1;j<T.length;j++){
                if(T[i]<T[j]){
                    if(isLarge){
                        if((i+flag) == T.length-2){
                            T[i] = flag+1;
                            isLarge =false;
                            break;
                        }else {
                            flag += 1;
                        }
                    }else {
                        T[i] = 1;
                    }
                    break;
                }else {
                    flag+=1;
                    isLarge =true;
                }

            }
            if(isLarge) {
                if (flag == T.length - i - 1) {
                    T[i] = 0;
                } else {
                    T[i] = flag;
                }
            }


        }
        T[T.length-1] = 0;


        return T;
    }

    public static void main(String[] args) {
        int[] arr = {77,77,77,77,77,41,77,41,41,77};
        System.out.println(new LeetCode_739().dailyTemperatures(arr));
    }
}
