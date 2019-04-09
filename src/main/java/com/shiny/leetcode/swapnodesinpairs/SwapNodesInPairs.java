package com.shiny.leetcode.swapnodesinpairs;

import com.shiny.leetcode.addtwonumbers.ListNode;

/**
 * @author DELL shiny
 * @create 2018/11/5
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(swapPairs(node1));
    }

    public static ListNode swapPairs(ListNode head) {
        // base case
        if(head == null || head.next == null){
            // size = 0 , size = 1
            return head;
        }

        // 奇数项
        ListNode node1 = head.next;
        // 下一个开始
        ListNode next = node1.next;
        //偶数项前移
        node1.next = head;
        //偶数项的指针
        head.next = swapPairs(next);
        return node1;
    }


}
