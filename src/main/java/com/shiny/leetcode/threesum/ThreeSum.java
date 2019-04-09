package com.shiny.leetcode.threesum;

import java.util.*;

/**
 * @author DELL shiny
 * @create 2018/10/18
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i < nums.length - 2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            int target=0-nums[i];
            twoSum(nums,i+1,target,result);
        }
        return result;
    }

    static void twoSum(int[] nums,int start,int target,List<List<Integer>> result){
        int head=start,tail=nums.length-1;
        while (head<tail){
            int tmp=nums[head]+nums[tail];
            if(tmp<target){
                head++;
            }else if(tmp>target){
                tail--;
            }else {
                List<Integer> inter =new ArrayList<Integer>();
                inter.add(nums[start-1]);
                inter.add(nums[head]);
                inter.add(nums[tail]);
                result.add(inter);
                int k = head+1;
                while(k < tail && nums[k] == nums[head]){
                    k++;
                }
                head = k;
                k = tail-1;
                while(k > head && nums[k] == nums[tail]){
                    k--;
                }
                tail = k;
            }
        }
    }
}
