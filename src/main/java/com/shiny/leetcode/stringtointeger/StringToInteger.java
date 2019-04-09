package com.shiny.leetcode.stringtointeger;

import java.math.BigInteger;

/**
 * @author DELL shiny
 * @create 2018/10/17
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("20900000000000000"));
    }

    public static int myAtoi(String str) {
        if(str.equals("")){
            return 0;
        }
        String temp=str.replaceAll(" ","");
        StringBuilder stringBuilder=new StringBuilder();
        BigInteger compare;
        boolean flag=false;
        for(int i=0;i<temp.length();i++) {
            char tmp=temp.charAt(i);
            if(i==0){
                if(tmp=='-'){
                    flag=true;
                }else if(tmp=='+') {
                }else{
                    if(isMatch(tmp-'0')){
                        stringBuilder.append(tmp);
                    }else {
                        return 0;
                    }
                }
            }else {
                if (isMatch(tmp-'0')) {
                    stringBuilder.append(tmp);
                }else {
                    break;
                }
            }
        }
        if(stringBuilder.length()==0){
            return 0;
        }
        if(stringBuilder.substring(0,1).equals("0")){
            return 0;
        }
        compare= new BigInteger(stringBuilder.toString());
        if(flag){
            if(compare.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE).substring(1)))>=0){
                return Integer.MIN_VALUE;
            }
            return 0-compare.intValue();
        }
        if (compare.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>=0) {
            return Integer.MAX_VALUE;
        }
        return compare.intValue();
    }

    private static boolean isMatch(int c){
        if(c>-1&c<10){
            return true;
        }
        return false;
    }
}
