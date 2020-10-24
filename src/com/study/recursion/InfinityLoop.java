package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : 나의 최약체 순환 함수을 뽀개기 위한 위대한 여정의 시작
 * @discription :
 * 1. recursion은 자기 자신을 다시 호출하는 함수이다.
 * 2. 조건없는 recursion은 무한 루프에 빠진다.
 * **/

public class InfinityLoop {
    public static void main(String[] args) {
        func();
    }

    public static void func(){
        System.out.println("Hello..");
        func();
    }
}
