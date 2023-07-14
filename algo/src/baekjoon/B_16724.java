package baekjoon;

import java.io.*;
import java.util.*;

public class B_16724 {
    static int N, M, ret, num;
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = ++num;
                    countArea(i, j);
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }

    static void countArea(int i, int j) {
        if (map[i][j] == 'D') {
            int ni = i + 1;
            int nj = j;
            if (ni < N) {
                if (visited[ni][nj] == 0) {
                    visited[ni][nj] = num;
                    countArea(ni, nj);
                } else if (visited[ni][nj] != num) {
                    ret--;
                }
            }
        } else if (map[i][j] == 'U') {
            int ni = i - 1;
            int nj = j;
            if (ni >= 0) {
                if (visited[ni][nj] == 0) {
                    visited[ni][nj] = num;
                    countArea(ni, nj);
                } else if (visited[ni][nj] != num) {
                    ret--;
                }
            }
        } else if (map[i][j] == 'L') {
            int ni = i;
            int nj = j - 1;
            if (nj >= 0) {
                if (visited[ni][nj] == 0) {
                    visited[ni][nj] = num;
                    countArea(ni, nj);
                } else if (visited[ni][nj] != num) {
                    ret--;
                }
            }
        } else if (map[i][j] == 'R') {
            int ni = i;
            int nj = j + 1;
            if (nj < M) {
                if (visited[ni][nj] == 0) {
                    visited[ni][nj] = num;
                    countArea(ni, nj);
                } else if (visited[ni][nj] != num) {
                    ret--;
                }
            }
        }
    }
}
