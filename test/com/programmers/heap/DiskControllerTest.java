package com.programmers.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiskControllerTest {
    @Test
    void solution() {
        int[][] jobs= {{0,3},{1,9},{2,6}};
        Assertions.assertEquals(new DiskController().solution(jobs),9);
    }
}
