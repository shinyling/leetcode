package com.shiny.leetcode.removeelement;

/**
 * @author DELL shiny
 * @create 2018/11/6
 */
public class RemoveElement {


    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2,2,3,0,4,2};
        int count=removeElement(nums,2);
        for(int i=0;i<count;i++){
            System.out.print(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
