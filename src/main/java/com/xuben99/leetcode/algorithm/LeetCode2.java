package com.xuben99.leetcode.algorithm;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */

public class LeetCode2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        while (l1 !=null || l2!=null){
            int l1val = l1!=null? l1.val : 0;
            int l2val = l2!=null? l2.val : 0;
            ListNode sumNode = new ListNode((l1val+l2val+carry)%10);
            carry = (l1val+l2val+carry)/10;
            cursor.next = sumNode;
            cursor = sumNode;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2 =l2.next;

        }
        return root.next;
    }

    public static void main(String[] args) {

    }

}
