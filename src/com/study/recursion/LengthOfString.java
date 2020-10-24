package com.study.recursion;
/**
 * @date : 2020-10-24
 * @title : recursion으로 문자열 길이 구하기
 **/
public class LengthOfString {
    public static void main(String[] args) {
        String str = "tell";
        System.out.println("str length = " + calcLength(str));
    }

    private static int calcLength(String str) {
        if (str.equals("")) return 0;
        return 1 + calcLength(str.substring(1));
    }
}

