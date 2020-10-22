package com.programmers.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MorehotTest {
    @Test
    void solution() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        Assertions.assertEquals(new MoreHot().solution(scoville, k),2);
    }
}
