package com.shiny.leetcode.regularexpressionmatching;

/**
 * @todo not done
 * @author DELL shiny
 * @create 2018/10/18
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        int[] result=new int[]{};
        System.out.println(isMatch("aab","c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        if(s==null||s.length()==0){
            if(p==null){
                return true;
            }else {
                if(p.replaceAll(".*","")==null){
                    return true;
                }
            }
        }
        if(s.equals(p)){
            return true;
        }
        if(p.equals(".*")){
            return true;
        }
        int j=0;
        char[] ss=s.toCharArray();
        char[] ps=p.toCharArray();
        for(int i=0;i<ps.length&&j<ss.length;i++,j++){
            if(ss[j]==ps[i]){
                continue;
            }else {
                //1:.2:.*3:n*
                if(ps[i]=='.'||p.substring(0,i).indexOf(".*")!=-1||(ps[i-1]==ss[j]&&ps[i]=='*')){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
