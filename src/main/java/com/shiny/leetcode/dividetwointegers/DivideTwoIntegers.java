package com.shiny.leetcode.dividetwointegers;

import java.math.BigInteger;

/**
 * @author DELL shiny
 * @create 2018/11/6
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(2147483647,1));
    }

    public static int divide(int dividend, int divisor) {
        long res=0;
        boolean bigThenZero=true;
        if(dividend>0&&divisor>0||dividend<0&&divisor<0){

        }else {
            bigThenZero=false;
        }
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        while (dividend-divisor>=0){
            dividend=dividend-divisor;
            res++;
        }
        if(res<Integer.MIN_VALUE||res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return bigThenZero?(int)res:(int)-res;
    }
}
