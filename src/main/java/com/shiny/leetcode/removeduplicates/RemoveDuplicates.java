package com.shiny.leetcode.removeduplicates;

/**
 * @author DELL shiny
 * @create 2018/11/5
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int count=removeDuplicates(nums);
        for(int i=0;i<count;i++){
            System.out.print(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
