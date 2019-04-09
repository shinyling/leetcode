package com.shiny.leetcode.integertoroman;

/**
 * @author DELL shiny
 * @create 2018/10/18
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(110));
    }

    static String intToRoman(int num) {
        if(num<10){
            return solve(num,"I","V","X");
        }
        if(num<100){
            return solve(num/10,"X","L","C")+solve(num%10,"I","V","X");
        }
        if(num<1000){
            return solve(num/100,"C","D","M")+solve(num%100/10,"X","L","C")+solve(num%10,"I","V","X");
        }
        if(num<4000){
            return solve(num/1000,"M","","")+solve(num%1000/100,"C","D","M")+solve(num%100/10,"X","L","C")+solve(num%10,"I","V","X");
        }
        return null;
    }

    static String solve(int g,String add,String mid,String next){
        String tmp="";
        if(g<4){
            for(int i=0;i<g;i++){
                tmp+=add;
            }
            return tmp;
        }
        for(int i=0;i<Math.abs(g-5);i++){
            tmp+=add;
        }
        if(g<5){
            return tmp+mid;
        }
        if(g==9){
            return add+next;
        }
        return mid+tmp;
    }
}
