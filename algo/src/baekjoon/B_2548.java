package baekjoon;

import java.io.*;
import java.util.*;

public class B_2548 {
    static int N, M;
//    static ArrayList<Integer>[] graph;
//    static ArrayList<Integer>[] reversedGraph;
//    static HashSet<Integer>[] arr;
    static int[][] graph;
    static int[][] reversedGraph;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        graph = new ArrayList[N + 1];
//        reversedGraph = new ArrayList[N + 1];
        graph = new int[N + 1][N + 1];
        reversedGraph = new int[N + 1][N + 1];
//        arr = new HashSet[N + 1];
        arr = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            graph[i] = new ArrayList<>();
//            reversedGraph[i] = new ArrayList<>();
////            arr[i] = new HashSet<>();
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

//            graph[from].add(to);
//            reversedGraph[to].add(from);
            graph[from][to] = 1;
            reversedGraph[to][from] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            // 초기화 진행
            if (!q.isEmpty())
                q.clear();
            for (int k = 0; k <= N; k++) {
                visited[k] = false;
            }
            int start = i;

            visited[start] = true;
            q.offer(start);
            int cnt = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
//                for (int next : graph[cur]) {
                for (int next = 1; next <= N; next++) {
                    if (graph[cur][next] == 1) {
                        if (!visited[next]) {
                            visited[next] = true;
                            cnt++;
                            q.offer(next);
                        }
                    }
//                    if (cur != start) {
//                        arr[cur].add(start);
//                        arr[start].add(cur);
//                        arr[start].add(next);
//                    } else {
//                        arr[cur].add(next);
//                        arr[next].add(cur);
//                        arr[next].add(start);
//                    }
//                    q.offer(next);
                }
            }
            arr[start] += cnt;
        }
        for (int i = 1; i <= N; i++) {
            // 초기화 진행
            if (!q.isEmpty())
                q.clear();
            for (int k = 0; k <= N; k++) {
                visited[k] = false;
            }
            int start = i;

            visited[start] = true;
            q.offer(start);
            int cnt = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
//                for (int next : reversedGraph[cur]) {
                for (int next = 1; next <= N; next++) {
                    if (reversedGraph[cur][next] == 1) {
                        if (!visited[next]) {
                            visited[next] = true;
                            cnt++;
                            q.offer(next);
                        }
                    }
//                    if (cur != start) {
//                        arr[cur].add(start);
//                        arr[start].add(cur);
//                        arr[start].add(next);
//                    } else {
//                        arr[cur].add(next);
//                        arr[next].add(cur);
//                        arr[next].add(start);
//                    }
//                    q.offer(next);
                }
            }
            arr[start] += cnt;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
//            int count = arr[i].size();
            int count = arr[i];
            System.out.println(count);
            if (count == N - 1)
                cnt++;
        }
        System.out.println(cnt);
    }
}