package com.shiny.leetcode.substringwithallwords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/12/24
 */
public class SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<Integer>();

        for(int i=0;i<words.length;i++){
            String word=words[i];
            Integer index=s.indexOf(word);
            if(index!=-1){
                int j=i+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
