package com.shiny.leetcode.medianoftwosortedarrays;

/**
 * @author DELL shiny
 * @create 2018/10/15
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1=new int[]{1,3,6};
        int[] num2=new int[]{2,4,5,8};
        System.out.println(findMedianSortedArrays(num1,num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            int[] temp=nums1;nums1=nums2;nums2=temp;
            int tmp=m;m=n;n=tmp;
        }
        int iMin=0,iMax=m,halfLen=(n+m+1)/2;
        while(iMin<=iMax){
            int i=(iMin+iMax)/2;
            int j=halfLen-i;
            if(i<iMax&&nums2[j-1]>nums1[i]){//第二个数组的left最后一个大于第一个数组的right的第一个。
                iMin=iMin+1;
            }else if(i>iMin&&nums1[i-1]>nums2[j]){//第一个数组left最后一个大于第二个数组的第一个。
                iMax=iMax-1;
            }else {
                int maxLeft=0;
                if(i==0){
                    maxLeft=nums2[j-1];
                }else if(j==0){
                    maxLeft=nums1[i-1];
                }else {
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)/2==1){
                    return maxLeft;
                }
                int minRight=0;
                if(i==m){
                    minRight=nums2[j];
                }else if(j==n){
                    minRight=nums1[i];
                }else {
                    minRight=Math.min(nums2[j],nums1[i]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
