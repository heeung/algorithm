package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1613 {
    static int N, K, S;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            graph[pre][now] = -1; // 제대로 된 경우가 -1
            graph[now][pre] = 1; // 거꾸로 된 경우가 1
        }

        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end ++) {
                    if (start == end || start == mid || mid == end)
                        continue;
                    if (graph[start][mid] * graph[mid][end] == 1 && graph[start][end] == 0) {
                        graph[start][end] = graph[start][mid];
                    }
                }
            }
        }

        S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(graph[start][end]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
