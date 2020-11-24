package com.study.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @date : 2020-11-23
 * @title : Tail Call 방식을 통한 Recursion의 최적화
 * @description : 간단한 recursion 함수를 tail call을 통하여 다시 구현해보았다.
 * @thoughts :
 * Tail Call 방식으로 짜여지면 Stack을 새로 만들지 않고
 * 이미 있는 Stack 속의 값만 대체해서 Stack을 재사용하는 방식으로 동작하도록 최적화 할 수 있다.
 * 이러한 최적화를 Tail Call Optimization(또는 Tail Call Elimination)이라고 하며 언어의 실행 환경에서 지원해줘야 한다.
 *
 * recursion을 사용할 때, 너무 호출을 많이하거나 스택이 터져버리진 않을까..
 * 고민했던 적이 있었는데 이런 방법이 있었다니..!
 * 똑같은 일을 하는 함수인데 어떻게 구현하냐에 따라서 이렇게 성능이 달라질 수 있다니, 신기하다.
 * 또 이렇게 하나 배웠따..!!!!!!!
 *
 **/
class tailRecursionTest {

    @Test
    @DisplayName("Recursion을 사용하여 Fibonacci 수열을 구하다.")
    void fibonacciTest() {
        int n = 10;
        Assertions.assertEquals(55,fibonacci(10));
        // 함수의 호출 횟수가 너무 많아져서 뻗는다..!
        //Assertions.assertEquals(55,commonFibonacci(100));
    }

    @Test
    @DisplayName("Recursion을 사용하여 0부터 n까지 합을 구하다.")
    void sumTest() {
        int n = 10;
        //StackOverflow - 스택의 깊이가 너무 커져서 뻗는다..!
        Assertions.assertEquals(55,sum(10000000));
    }

    @Test
    @DisplayName("for문을 사용하여 0부터 n까지 합을 구하다.")
    void fibonacciLoopTest() {
        int n = 10;
        Assertions.assertEquals(55,fibonacciLoop(10000000));
    }

    @Test
    @DisplayName("tail recursion을 통하여 피보나치 수를 구하다.")
    void fibonacciTailTest() {
        int n = 10;
        Assertions.assertEquals(55,fibonacciTail(10,1,0));
    }

    @Test
    @DisplayName("tail recursion을 통하여 피보나치 수를 구하다.(더 간결하게)")
    void fibonacciTailTest2() {
        int n = 10;
        Assertions.assertEquals(55,fibonacciTail2(10,1,0));
    }
    public int fibonacciTail (int n, int prevFibo, int prevPrevFibo){
            int currFibo;
            if (n < 2)
                return n * prevFibo;

            currFibo = prevFibo + prevPrevFibo;
            prevPrevFibo = prevFibo;
            prevFibo = currFibo;

            return fibonacciTail(n - 1, prevFibo, prevPrevFibo);
    }
    public int fibonacciTail2 (int n, int prevFibo, int prevPrevFibo){
            if (n < 2)
                return n * prevFibo;
            return fibonacciTail(n - 1, prevFibo+prevPrevFibo, prevFibo);
    }
    public int fibonacciLoop(int n) {
        int currFibo = 0; int prevFibo = 1; int prevPrevFibo = 0;
        if (n < 2)
            return n;
        //n까지 for문을 돌면서
        for ( int i = 2 ; i <= n ; i++ ) {
            // 이번 반복의 피보나치 수를 구하고
            currFibo = prevFibo + prevPrevFibo;
            // 다음번 반복을 위해 직전의 피보나치 수를 한칸 더 앞으로 땡기고
            prevPrevFibo = prevFibo;
            // 현재의 피보나치 수는 직전 피보나치수로 바꾼다.
            prevFibo = currFibo;
        }
        return currFibo;
    }
    public int fibonacci(int n){
        if (n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public int sum(int n){
        if (n < 2)
            return n;
        return n + sum(n - 1);
    }
}
