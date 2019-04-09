package com.shiny.leetcode.lettercombianationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DELL shiny
 * @create 2018/10/25
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("269"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer,String> yinshe=new HashMap<Integer, String>(8);
        yinshe.put(2,"abc");
        yinshe.put(3,"def");
        yinshe.put(4,"ghi");
        yinshe.put(5,"jkl");
        yinshe.put(6,"mno");
        yinshe.put(7,"pqrs");
        yinshe.put(8,"tuv");
        yinshe.put(9,"wxyz");
        char[] region=digits.toCharArray();
        List<String> result=new ArrayList<String>();
        for(int i=0;i<region.length;i++){
            int temp=region[i]-'0';
            String str=yinshe.get(temp);
            result=pinjie(str,result);
        }
        return result;
    }

    private static List<String> pinjie(String tmp,List<String> res){
        List<String> temp=new ArrayList<String>();
        if(res==null||res.size()==0){
            for(int i=0;i<tmp.length();i++){
                temp.add(String.valueOf(tmp.charAt(i)));
            }
        }else {
            for (int i=0;i<res.size();i++){
                String s=res.get(i);
                for(int j=0;j<tmp.length();j++){
                    temp.add(s+String.valueOf(tmp.charAt(j)));
                }
            }
        }
        return temp;
    }
}
