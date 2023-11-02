package programmers;

import java.util.Arrays;

public class P_기둥과_보_설치 {
    public static void main(String[] args) {

    }

    static final int COLUMN = 0;
    static final int ROW = 1;
    static class Point {
        boolean left, right, up, down;
    }
    static Point[][] wall;
    static class Solution {
        public int[][] solution(int n, int[][] build_frame) {
            int[][] answer = {};
            wall = new Point[n + 2][n + 2];

            for (int[] now : build_frame) {
                int x = now[0];
                int y = now[1];
                int type = now[2];
                int command = now[3];

                if (command == 1) { // 1 == 건설
                    if (type == COLUMN && isColumnPossible(x, y)) {
                        wall[x][y].up = true;
                        wall[x][y + 1].down = true;
                    }
                    if (type == ROW && isRowPossible(x, y)) {
                        wall[x][y].right = true;
                        wall[x + 1][y].left = true;
                    }
                } else { // 0 == 삭제
                    if (type == COLUMN && isColumnDeletePossible(x, y)) {
                        // TODO
                    }
                }
            }

            return answer;
        }
        static boolean isColumnPossible(int x, int y) {
            return y == 0 || wall[x][y].left || wall[x][y].right || wall[x][y].down;
        }
        static boolean isRowPossible(int x, int y) {
            return wall[x][y].down || wall[x + 1][y].down || (wall[x][y].left && wall[x][y].right);
        }
        static boolean isColumnDeletePossible(int x, int y) {
            return !wall[x][y].up && (wall[x][y].right && wall[x + 1][y].down) && (wall[x][y].left && wall[x - 1][y].down);
        }
        static boolean isRowDeletePossible(int x, int y) {
            // TODO
            return false;
        }
    }
}
