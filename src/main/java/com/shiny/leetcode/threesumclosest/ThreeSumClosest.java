package com.shiny.leetcode.threesumclosest;

import java.util.Arrays;

/**
 * @author DELL shiny
 * @create 2018/10/19
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums=new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        int target=-52;
        System.out.println(threeSumClosest(nums,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        int result=Integer.MAX_VALUE,dis=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            //三数之和如果是0后面的就可以不用考虑了
            if(i>0) {
                if (nums[i] > target) {
                    break;
                }
            }
            //第二个数
            int start=i+1;
            //目标值与第一个给定数字的差值
            int tmp=target-nums[i];
            //计算两个数与目标值相差最小的和
            int tmpTwoClosest=twoSumClosest(nums,start,tmp);
            //差距变量
            int tmpDis;
            if((tmpDis=Math.abs(tmpTwoClosest-tmp))<dis){
                result=nums[i]+tmpTwoClosest;
                dis=tmpDis;
                if(result==target){
                    return result;
                }
            }
        }
        return result;
    }

    public static int twoSumClosest(int[] nums,int start,int target){
        int head=start,tail=nums.length-1;
        int ret=Integer.MAX_VALUE;
        int tmp=Integer.MAX_VALUE;
        while (head<tail){
            if(nums[head]+nums[tail]<target){
                if(ret>target-(nums[head]+nums[tail])){
                    ret=target-(nums[head]+nums[tail]);
                    tmp=nums[head]+nums[tail];
                }
                head++;
            }else {
                if(ret>(nums[head]+nums[tail])-target){
                    ret=(nums[head]+nums[tail])-target;
                    tmp=nums[head]+nums[tail];
                }
                tail--;
            }
        }
        return tmp;
    }
}
