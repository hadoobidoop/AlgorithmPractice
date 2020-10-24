package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : n!을 구하는 recursion
 * @description : n!은 n에 1에서 n-1까지의 곱을 곱하는 것과 같다.
 **/
public class NFactorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("nFactorial = " + nFactorial(n));
    }

    private static int nFactorial(int n) {
        if(n==0) return 1;
        return n * nFactorial(n-1);
    }

}
