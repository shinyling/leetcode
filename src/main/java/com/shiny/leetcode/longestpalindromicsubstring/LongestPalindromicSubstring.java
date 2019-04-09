package com.shiny.leetcode.longestpalindromicsubstring;

import java.util.*;

/**
 * 最长回文字串
 * @author DELL shiny
 * @create 2018/10/15
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbbb"));
    }

    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        Map<Integer,String> size=new HashMap<Integer, String>();
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            int index=i;
            while (index!=-1){
                index=s.indexOf(temp,index+1);
                if(index==-1){
                    break;
                }
                String tmpStr=s.substring(i,index+1);
                if(checkForPalindromic(tmpStr)){
                    maxLen=Math.max(index-i,maxLen);
                    size.put(index-i,tmpStr);
                }
            }
        }
        if(maxLen==0){
            return s.charAt(0)+"";
        }
        return size.get(maxLen);
    }

    public static boolean checkForPalindromic(String s){
        int len=s.length();
        int mid=len/2;
        for(int i=0;i<mid;i++){
            if(s.charAt(i)==s.charAt(len-(i+1))){
                continue;
            }
            return false;
        }
        return true;
    }
}
