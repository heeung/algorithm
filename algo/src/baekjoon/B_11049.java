package baekjoon;

import java.io.*;
import java.util.*;

public class B_11049 {
    static class Matrix {
        int start, end;

        public Matrix(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];

        Matrix[] arr = new Matrix[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int len = 0; len < N; len++) {

        }
    }
}

/*

[0][0] [0][1] [0][2]
[1][0] [1][1] [1][2]
[2][0] [2][1] [2][2]

[x] [x] [x]
[x] [x] [x]
[x] [x] [x]

 */