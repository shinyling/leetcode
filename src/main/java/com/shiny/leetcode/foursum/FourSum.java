package com.shiny.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/10/25
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums=new int[]{1,-2,-5,-4,-3,3,3,5};
        int target=-11;
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }
            for(int j=i+1;j<nums.length-2;j++){
                int left=target-nums[i]-nums[j];
                int start=j+1;
                if(j>i+1){
                    if(nums[j]==nums[j-1]){
                        continue;
                    }
                }
                result=twoSum(i,j,start,left,nums,result);
            }
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int i,int j,int start,int target,int[] nums,List<List<Integer>> result){
        int tail=nums.length-1;
        while (start<tail){
            if(nums[start]+nums[tail]>target){
                tail--;
            }else if(nums[start]+nums[tail]==target){
                if(start>j+1){
                    if(nums[start]==nums[start-1]){
                        start++;
                        continue;
                    }
                }
                if(tail<nums.length-1){
                    if(nums[tail]==nums[tail+1]){
                        tail--;
                        continue;
                    }
                }
                List<Integer> tmp=new ArrayList<Integer>(4);
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                tmp.add(nums[start]);
                tmp.add(nums[tail]);
                result.add(tmp);
                start++;
                tail--;
            }else {
                start++;
            }
        }
        return result;
    }
}
