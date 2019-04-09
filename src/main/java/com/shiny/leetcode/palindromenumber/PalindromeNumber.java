package com.shiny.leetcode.palindromenumber;

/**
 * @author DELL shiny
 * @create 2018/10/17
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String number=String.valueOf(x);
        int len=number.length()/2;
        int i=len,j=len;
        if(number.length()<2){
            return true;
        }else if(number.length()==2){
            return check(number,i-1,j);
        }
        if(check(number,i,j)||check(number,i-1,j)){
            return true;
        }
        return false;
    }

    private static boolean check(String number,int i,int j){
        for(;i>=0&&j<number.length();i--,j++){
            if(number.charAt(i)==number.charAt(j)){
                continue;
            }else {
                return false;
            }
        }
        if(i==-1&&j==number.length()) {
            return true;
        }
        return false;
    }
}
