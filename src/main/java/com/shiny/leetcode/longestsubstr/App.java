package com.shiny.leetcode.longestsubstr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL shiny
 * @create 2018/10/12
 */
public class App {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring("abba"));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        int size=0;
        Map<Character,Integer> result=new HashMap(arr.length);
        for(int i=0,j=0;i<arr.length;i++) {
            char curr = arr[i];
            if (result.containsKey(curr)){
                j=result.get(curr)+1;
            }
            result.put(curr,i);
            size=Math.max(size,i-j+1);
        }
        return size;
    }
}
