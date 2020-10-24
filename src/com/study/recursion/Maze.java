package com.study.recursion;

/**
 * @date : 2020-10-24
 * @title : recursion으로 미로 찾기
 * @thoughts : 오.. 성공!! recursion 늘 새로워 늘 짜릿해!
 * 모든 테스트를 main method로 작성해서 후회 중.. 다음부턴 테스트 클래스로 빼서 작성하자.
 **/
public class Maze {
    static int[][] maze = {{0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}};

    static int N = 8; // 8 * 8 사이즈 미로
    static int path = 0;
    static int wall = 1;
    static int blocked = 2;
    static int notBlocked = 3;

    static boolean findPath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= 8) return false;
        if (maze[x][y] != path) return false;
        if (x == N - 1 && y == N - 1) {
            maze[x][y] = notBlocked;
            return true;
        } else {
            maze[x][y] = notBlocked;
            if (findPath(x, y - 1) || findPath(x, y + 1) || findPath(x + 1, y) || findPath(x + 1, y - 1)) return true;
            maze[x][y] = blocked;
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("findPath = " + findPath(0, 0));
    }
}
