package com.programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @date : 2020-10-24
 * @question : https://programmers.co.kr/learn/courses/30/lessons/42627
 * @thoughts :
 * 1. 어려운 문제였다...ㅠㅠ
 * 2. SJF(Shortest Job First, 최소작업 우선 스케쥴링) : 수행 시간이 짧은 작업부터 처리하는 알고리즘
 * 3. 우선 순위 큐에 Comparator를 넘겨 원하는 기준으로 정렬할 수 있다. 이 경우에는 배열(job)을 넘기고 job의 처리 시간을 기준으로 정렬하도록 했다.
 * 4. 큐에 쌓인 작업은 다 끝났지만(유휴상태), 아직 jobs에 작업이 있다면, 다음 작업의 도착시간을 end에 넣어줬다. 아니면 무한 반복할 수도 있다.
**/
public class DiskController {
    public int solution(int[][] jobs) {
        int count = 0;
        int sum = 0;
        int end = 0;
        int index = 0;
        Arrays.sort(jobs, (o1, o2) -> { return Integer.compare(o1[0], o2[0]);});
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator.comparingInt(o1 -> o1[1]));
        while (count < jobs.length) {
            for (int i = 0; i < jobs.length; i++) {
                if (i >= index && jobs[i][0] <= end) {
                    queue.add(jobs[i]);
                    index++;
                }
            }
            if (!queue.isEmpty()) {
                sum = sum + end + queue.peek()[1] - queue.peek()[0];
                end = end + queue.poll()[1];
                count++;
            }else {
                end=jobs[index][0];
            }
        }
        return sum / jobs.length;
    }
}
