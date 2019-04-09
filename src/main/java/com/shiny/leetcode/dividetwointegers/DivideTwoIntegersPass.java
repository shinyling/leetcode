package com.shiny.leetcode.dividetwointegers;

/**
 * @author DELL shiny
 * @create 2018/11/6
 */
public class DivideTwoIntegersPass {

    public static void main(String[] args) {
        System.out.println(divide(-2147483647,1));
    }

    public static int divide(int dividend, int divisor) {
        long res=0;
        boolean bigThenZero=true;
        if(dividend>0&&divisor>0||dividend<0&&divisor<0){

        }else {
            bigThenZero=false;
        }
        if (divisor != Integer.MIN_VALUE && dividend != Integer.MIN_VALUE) {
            long temp = Math.abs((long) dividend);
            long tmp = Math.abs((long) divisor);
            while (tmp <= temp) {
                long multi = 1;
                while ((tmp << multi) <= temp) {
                    multi++;
                }
                res += (1 << (multi - 1));
                temp -= (tmp << (multi - 1));
            }
        }else {
            if (divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE ? 1 : 0;
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor > 0) divisor = -divisor;
            while (divisor <= dividend) {
                long multi = 1;
                while ((divisor << multi) <= dividend) {
                    multi++;
                }
                res += (1 << (multi - 1));
                dividend -= (divisor << (multi - 1));
            }
        }
        if(res<Integer.MIN_VALUE||res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return bigThenZero?(int)res:(int)-res;
    }
}
