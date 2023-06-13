package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1976 {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1)
                    graph[i].add(j);
            }
        }

        Queue<Integer> trip = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            trip.offer(Integer.parseInt(st.nextToken()));

        int pre = trip.poll();
        while (!trip.isEmpty()) {
            isPossible = false;
            int cur = trip.poll();
            visited = new boolean[N + 1];
            dfs(pre, cur);
            if (!isPossible) {
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");
    }

    public static void dfs(int from, int to) {
        if (from == to) {
            isPossible = true;
            return ;
        }

        visited[from] = true;

        for (Integer n : graph[from]) {
            if (!visited[n] && !isPossible) {
                dfs(n, to);
            }
        }
    }
}