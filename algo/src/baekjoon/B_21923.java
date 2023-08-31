package baekjoon;

import java.io.*;
import java.util.*;

public class B_21923 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] upDi = {1, 0};
    static int[] upDj = {0, 1};
    static int[] downDi = {-1, 0};
    static int[] downDj = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
//                dp[i][j] = Integer.MIN_VALUE;
            }
        }
    }
}
