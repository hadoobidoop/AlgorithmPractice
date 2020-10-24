package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : recursion을 이용한 배열의 탐색
 * @description : target 문자의 index를 찾는 알고리즘을 순차 탐색, 이진 탐색하여 구현해보았다.
 * @thoughts :
 * 1. 드디어 이진 탐색!! 이진 탐색은 정렬되어 있는 배열을 절반식 계속 잘라가면서 탐색한다. 짜릿하군
 *
 **/
public class SearchArray {

    public static void main(String[] args) {
        int [] arr = {0,8,1,4,7,3,5};
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        System.out.println("findIdx= " + findIdx(arr,target,0));
        System.out.println("findIdxExplicit = " + findIdxExplicit(arr,0,arr.length-1,3));
        System.out.println("findIdxDevided = " + findIdxDevided(arr,0,arr.length-1,3));
        System.out.println("findMax = " + findMax(arr,0,arr.length-1));
        System.out.println("binarySearch = " + binarySearch(sortedArr,0,sortedArr.length-1,3));

    }

    private static int findIdx(int[] arr, int target, int startIdx) {
        if (startIdx > arr.length - 1) return -1;
        if (arr[startIdx] == target) return startIdx;
        return findIdx(arr, target, startIdx + 1);
    }

    private static int findIdxExplicit(int[] data, int begin, int end, int target) {
        if (begin > end) return -1;
        else if (target == data[begin]) return begin;
        else return findIdxExplicit(data, begin + 1, end, target);
    }

    private static int findIdxDevided(int[] data, int begin, int end, int target) {
        if (begin > end) return -1;

        int middle = (begin + end)/2;
        if (target == data[middle]) return middle;

        int idx = findIdxDevided(data, begin, middle-1, target);
        if (idx != -1) return idx;
        else return findIdxDevided(data, middle + 1, end, target);
    }

    public static int findMax(int[] data, int begin, int end) {
        if (begin == end) {
            return data[begin];
        } else return Math.max(data[begin], findMax(data, begin + 1, end));
    }

    public static int binarySearch(int[] data, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }else {
            int middle = (begin + end) / 2;
            if (target == data[middle]) {
                return middle;
            } else if(target<data[middle]) {
                return binarySearch(data, begin, middle -1, target);
            } else return binarySearch(data, middle + 1, end, target);
        }
    }
}
