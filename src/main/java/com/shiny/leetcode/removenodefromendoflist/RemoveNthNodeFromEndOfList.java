package com.shiny.leetcode.removenodefromendoflist;

import com.shiny.leetcode.addtwonumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/10/25
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        l1.next=l2;
        ListNode l3=new ListNode(3);
        l2.next=l3;
        ListNode l4=new ListNode(4);
        l3.next=l4;
        ListNode l5=new ListNode(5);
        l4.next=l5;
        int n=3;
        System.out.println(removeNthFromEnd(l1,n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list=new ArrayList();
        ListNode tmp=head;
        while (tmp.next!=null){
            list.add(tmp);
            tmp=tmp.next;
        }
        list.add(tmp);
        if(list.size()==n){
            if(list.get(0).next==null) {
                return null;
            }else {
                ListNode node=list.get(0);
                node=node.next;
                return node;
            }
        }
        if(n>1) {
            list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
        }else {
            list.get(list.size()-n-1).next=null;
        }
        return head;
    }
}
