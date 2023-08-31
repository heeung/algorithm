package baekjoon;

import java.io.*;
import java.util.*;

public class B_2616 {
    static int N, num;
    static int[] arr, sum;
    static int[][] dp;
    class Node implements Comparable<Node> {
        int i;
        public Node(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        dp = new int[4][N + 1];
        num = Integer.parseInt(br.readLine());
        for (int i = 1; i < 4; i++) {
            for (int j = i * num; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - num] + (sum[j] - sum[j - num]));
            }
        }

        System.out.println(dp[3][N]);
    }
}
