package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : 무한루프에 빠지지 않는 좋은 Recursion이 되는 길
 * @discription :
 * 1. Base case - Recursion의 무한 루프를 탈출하기 위해 조건문이 꼭 필요하다. 이때 자기 자신을 호출하지 말고 recursion을 종료해야 한다.
 * 2. Recursive case - 처음에는 recursion을 반복하더라도, 언젠가는 꼭 basecase로 수렴해야 한다.
 * **/

public class RecursionWithCondition {
    public static void main(String[] args) {
        int n = 4;
        func(n);
    }

    public static void func(int k) {
        if (k <= 0) return; //base case
        System.out.println("hello");
        func(k-1);
    }
}
