package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : 0부터 n까지 더하는 recursion
 * @description : n이 0보다 크다면 0~n의 합은 0~n-1의 합에서 n을 더한 것이다.
 * 1. 1차 -> nSum(4) = 4 + nSum(3);
 * 2. 2차 -> nSum(3) = 3 + nSum(2)
 * 3. 3차 -> nSum(2) = 2 + nSum(1)
 * 4. 4차 -> nSum(1) = 1 + nSum(0)
 * 5. 5차 -> nSum(0) = return 0 !!! (탈출 조건)
 **/

public class NSum {
    public static void main(String[] args) {
        int n=4;
        System.out.println("sum : " + nSum(n));
    }

    public static int nSum(int n) {
        if (n ==0)  return 0;
        return n+nSum(n-1);
    }
}
