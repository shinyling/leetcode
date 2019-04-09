package com.shiny.leetcode.addtwonumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/10/12
 */
public class App {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(9);
        ListNode m=new ListNode(9);
        l2.next=m;
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list=new ArrayList();
        int jinwei=0;
        int i=0;
        do{
            ListNode temp=new ListNode(0);
            int sum=l1.val+l2.val+jinwei;
            jinwei=0;
            if(sum>=10){
                temp.val=sum-10;
                jinwei=1;
            }else{
                temp.val=sum;
            }
            list.add(temp);
            if(i>0){
                list.get(i-1).next=list.get(i);
            }
            l1=l1.next;
            l2=l2.next;
            i++;
        }while(l1!=null&&l2!=null);
        if(jinwei==1){
            if(l1==null&&l2!=null) {
                list.get(i - 1).next = addTwoNumbers(l2,new ListNode(1));
            }else if(l1!=null&&l2==null){
                list.get(i - 1).next = addTwoNumbers(l1,new ListNode(1));
            }else {
                list.get(i-1).next=new ListNode(1);
            }
        }else {
            if(l1==null){
                list.get(i-1).next=l2;
            }else {
                list.get(i-1).next=l1;
            }
        }
        return list.get(0);
    }
}
