package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* TODO(
    블록 '|', '-','+',
     1  |  2  |  3 |  4
    우하 | 우상 | 좌상 | 좌하
    ) */

class B_2931 {
    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int R, C;
    static Character[][] map;
    static Point start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'M') {
                    start = new Point(i, j);
                }
                if (map[i][j] == 'Z') {
                    end = new Point(i, j);
                }
            }
        }

        int ri, rj;
        Character ret;
        Loop:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // Z 일떄
                if (map[i][j] == '-') {
                    if (j - 1 >= 0) {
                        if (map[i][j - 1] == '.') {
                            solve(i, j - 1);
                            break Loop;
                        }
                    }
                    if (j + 1 < C) {
                        if (map[i][j + 1] == '.') {
                            solve(i, j + 1);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '+') {
                    if (j - 1 >= 0) { // 좌
                        if (map[i][j - 1] == '.') {
                            solve(i, j - 1);
                            break Loop;
                        }
                    }
                    if (j + 1 < C) { // 우
                        if (map[i][j + 1] == '.') {
                            solve(i, j + 1);
                            break Loop;
                        }
                    }
                    if (i - 1 >= 0) { // 상
                        if (map[i - 1][j] == '.') {
                            solve(i - 1, j);
                            break Loop;
                        }
                    }
                    if (i + 1 < R) { // 하
                        if (map[i + 1][j] == '.') {
                            solve(i + 1, j);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '|') {
                    if (i - 1 >= 0) { // 상
                        if (map[i - 1][j] == '.') {
                            solve(i - 1, j);
                            break Loop;
                        }
                    }
                    if (i + 1 < R) { // 하
                        if (map[i + 1][j] == '.') {
                            solve(i + 1, j);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '1') { /* TODO(우하) */
                    if (j + 1 < C) { // 우
                        if (map[i][j + 1] == '.') {
                            solve(i, j + 1);
                            break Loop;
                        }
                    }
                    if (i + 1 < R) { // 하
                        if (map[i + 1][j] == '.') {
                            solve(i + 1, j);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '2') { /* TODO(우상) */
                    if (j + 1 < C) { // 우
                        if (map[i][j + 1] == '.') {
                            solve(i, j + 1);
                            break Loop;
                        }
                    }
                    if (i - 1 >= 0) { // 상
                        if (map[i - 1][j] == '.') {
                            solve(i - 1, j);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '3') { /* TODO(좌상) */
                    if (j - 1 >= 0) { // 좌
                        if (map[i][j - 1] == '.') {
                            solve(i, j - 1);
                            break Loop;
                        }
                    }
                    if (i - 1 >= 0) { // 상
                        if (map[i - 1][j] == '.') {
                            solve(i - 1, j);
                            break Loop;
                        }
                    }
                } else if (map[i][j] == '4') { /* TODO(좌하) */
                    if (j - 1 >= 0) { // 좌
                        if (map[i][j - 1] == '.') {
                            solve(i, j - 1);
                            break Loop;
                        }
                    }
                    if (i + 1 < R) { // 하
                        if (map[i + 1][j] == '.') {
                            solve(i + 1, j);
                            break Loop;
                        }
                    }
                }
            }
        }
    }

    static void solve(int i, int j) {
        boolean left = false, right = false, top = false, bottom = false;

//        System.out.println(i + " " + j);
        if (j - 1 >= 0) { // 좌
            if (map[i][j - 1] == '-' || map[i][j - 1] == '+' || map[i][j - 1] == '1' || map[i][j - 1] == '2') {
                left = true;
            }
        }
        if (j + 1 < C) { // 우
            if (map[i][j + 1] == '-' || map[i][j + 1] == '+' || map[i][j + 1] == '3' || map[i][j + 1] == '4') {
                right = true;
            }
        }
        if (i - 1 >= 0) { // 상
            if (map[i - 1][j] == '|' || map[i - 1][j] == '+' || map[i - 1][j] == '1' || map[i - 1][j] == '4') {
                top = true;
            }
        }
        if (i + 1 < R) { // 하
            if (map[i + 1][j] == '|' || map[i + 1][j] == '+' || map[i + 1][j] == '2' || map[i + 1][j] == '3') {
                bottom = true;
            }
        }

        if (left && right && top && bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '+');
        }
        if (left && right && !top && !bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '-');
        }
        if (!left && !right && top && bottom) {
            System.out.println(i + 1 + " " + (j + 1)+ " " + '|');
        }
        if (!left && right && !top && bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '1');
        }
        if (!left && right && top && !bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '2');
        }
        if (left && !right && top && !bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '3');
        }
        if (left && !right && !top && bottom) {
            System.out.println(i + 1 + " " + (j + 1) + " " + '4');
        }
    }
}