package com.shiny.leetcode.longestpalindromicsubstring;

/**
 * @author DELL shiny
 * @create 2018/10/15
 * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
 */
public class Answer {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//从中间1个向两边扩展解决类似aba这种
            int len2 = expandAroundCenter(s, i, i + 1);//从中间两个向两边扩展
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;//start为当前位置减去1/2的字符串长度
                end = i + len / 2;//end为当前位置加上1/2的字符串长度
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
