package com.xuben99.leetcode.algorithm;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 */
public class LeetCode10 {

    public boolean isMatch(String s, String p) {
        if (s.length()==0 || (p.length()>0&&s.length()==1&&p.charAt(0)=='.')  ){
            return true;
        }
        if(p.length()==0){
            return false;
        }
        int sIndex = 0;
        int count = 0;
        for (int i =0;i<p.length();i++) {

                if (p.charAt(i) == s.charAt(sIndex) || p.charAt(i) == '.') {
                    sIndex += 1;
                    count += 1;
                } else if (i > 0 && p.charAt(i) == '*' ) {
                    if( p.charAt(i-1)=='.'){
                        sIndex += 1;
                        count += 1;
                        i--;
                    }else if ( s.charAt(sIndex) == p.charAt(i-1))
                    {
                    sIndex += 1;
                    count += 1;
                    i--;
                    }else if ( s.charAt(sIndex) == p.charAt(i)){
                        sIndex += 1;
                        count += 1;
                    }
                } else {
                    sIndex = 0;
                    count = 0;
                }
                int j ;
                if(p.length()>i+1 &&p.charAt(i+1)=='*') {
                     j = i + 1;
                }else {
                     j=i;
                }
                if (count == s.length()){
                    if(j+1!=p.length()){
                        for ( ;j< p.length();j++){
                            if(j+1<p.length()&&p.charAt(j)=='*' && p.charAt(j+1)==s.charAt(s.length()-1)) return true;
                            if (p.charAt(j)!='.' || p.charAt(j) != '*') return false;
                        }
                    }
                    return true;
                }



        }


        return false;

    }

    public boolean isMatch2(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode10().isMatch2("aaa", "a*a"));
    }
}
