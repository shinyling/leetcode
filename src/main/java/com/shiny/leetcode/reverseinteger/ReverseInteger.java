package com.shiny.leetcode.reverseinteger;

/**
 * @author DELL shiny
 * @create 2018/10/16
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-120));
    }

    public static int reverse(int x) {
        boolean lessThanZero=false;
        String result="";
        if(x>0) {
            result = String.valueOf(x);
        }else if(x<0){
            lessThanZero=true;
            result=String.valueOf(x).substring(1);
        }
        StringBuilder reverse=new StringBuilder();
        for(int i=result.length()-1;i>=0;i--){
            reverse.append(result.charAt(i));
        }
        if(reverse.length()==0){
            return 0;
        }
        Long res=Long.valueOf(reverse.toString());
        if(lessThanZero){
            res=-res;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return res.intValue();
    }

}
