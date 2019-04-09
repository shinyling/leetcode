package com.shiny.leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：递归调用完成返回上一次未完成的操作
 * @author DELL shiny
 * @create 2018/10/26
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if(cur.length() == max*2){
            ans.add(cur);
            return;
        }
        if(open<max)
            backtrack(ans,cur+"(",open+1,close,max);
        if(close<open)
            backtrack(ans,cur+")",open,close+1,max);
    }
}
