package com.shiny.leetcode.implementstrstr;

/**
 * @author DELL shiny
 * @create 2018/11/6
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        String heystack="mississippi";
        String needle="issip";
        System.out.println(strStr(heystack,needle));
    }


    public static int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int index=-1;
        int len=haystack.length();
        int i=0,j=0;
        int needLen=needle.length();
        for(;i<len;i++){
            if(j==needLen){
                return i - needLen;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i=i-j;
                j = 0;
            }
        }
        if(j==needLen){
            return i - needLen;
        }
        return index;
    }
}
