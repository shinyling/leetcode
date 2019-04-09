package com.shiny.leetcode.mergeksortedlists;

import com.shiny.leetcode.addtwonumbers.ListNode;

/**
 * 这里来复习一下Merge Sort(对于数组操作），参考Wikipedia：

 归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。

 归并操作的过程如下：

 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 重复步骤3直到某一指针到达序列尾
 将另一序列剩下的所有元素直接复制到合并序列尾
 * @author DELL shiny
 * @create 2018/10/26
 */
public class MergeSortedLists {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(3);
        l1.next=l2;
        ListNode l3=new ListNode(2);
        ListNode l4=new ListNode(4);
        l3.next=l4;
        ListNode l5=new ListNode(6);
        l4.next=l5;
        ListNode[] lists=new ListNode[]{l1,l3};
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        return Msort(lists,0,lists.length-1);
    }

    public static ListNode Msort(ListNode[] listNodes,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            ListNode left=Msort(listNodes,low,mid);
            ListNode right=Msort(listNodes,mid+1,high);
            return mergeTwoLists(left,right);
        }
        return listNodes[low];
    }

    public static ListNode mergeTwoLists(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode node3;
        if(node1.val<node2.val){
            node3=node1;
            node1=node1.next;
        }else {
            node3=node2;
            node2=node2.next;
        }
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=node3;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                node3.next=node1;
                node1=node1.next;
                node3=node3.next;
            }else {
                node3.next=node2;
                node2=node2.next;
                node3=node3.next;
            }
        }
        if(node1!=null){
            node3.next=node1;
        }
        if(node2!=null){
            node3.next=node2;
        }
        return fakeHead.next;
    }
}
