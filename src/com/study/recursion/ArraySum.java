package com.study.recursion;
/**
 * @date : 2020-10-24
 * @title : recursion으로 array 안의 정수를 모두 더하기
 **/
public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int index = 0;
        System.out.println("arraySum(data) = " + arraySum(arr,index));
    }

    private static int arraySum(int[] arr,int index) {
        if (index > arr.length-1) {
            return 0;
        }
        return arr[index] + arraySum(arr,index+1);
    }
}

