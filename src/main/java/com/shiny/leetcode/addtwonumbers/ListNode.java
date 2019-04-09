package com.shiny.leetcode.addtwonumbers;

/**
 * @author DELL shiny
 * @create 2018/10/12
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if(next!=null) {
            return val + next.toString();
        }
        return val+"";
    }
}
