package com.study.recursion;
/**
 * @date : 2020-10-24
 * @title : recursion으로 문자열 출력하기
 * @description : 정방향으로 출력하는 것과 역으로 출력하는 것. 두가지를 구현함
 **/
public class PrintChars {
    public static void main(String[] args) {
        String str = "abc";
        printChars(str);
        reversePintChars(str);
    }

    private static void printChars(String str) {
        if(str.equals(""))return;
        System.out.print(str.charAt(0));
        printChars(str.substring(1));
    }

    private static void reversePintChars(String str) {
        if(str.equals("")) return;
        reversePintChars(str.substring(1));
        System.out.print(str.charAt(0));
    }
}
