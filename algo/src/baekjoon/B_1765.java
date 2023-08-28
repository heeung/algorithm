package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1765 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> enemys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        enemys = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            char isFriends = st.nextToken().charAt(0);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (isFriends == 'E') {
                if (enemys.containsKey(from)) {
                    for (int now : enemys.get(from)) {
                        graph[from].add(now);
                        graph[now].add(from);
                    }
                    enemys.get(from).add(to);
                    if (!enemys.containsKey(to)) {
                        enemys.put(to, new ArrayList<>());
                    }
                    enemys.get(to).add(from);
                } else if (enemys.containsKey(to)) {
                    for (int now : enemys.get(to)) {
                        graph[to].add(now);
                        graph[now].add(to);
                    }
                    enemys.get(to).add(from);
                    if (!enemys.containsKey(from)) {
                        enemys.put(from, new ArrayList<>());
                    }
                    enemys.get(from).add(to);
                } else {
                    enemys.put(from, new ArrayList<>());
                    enemys.get(from).add(to);
                    enemys.put(to, new ArrayList<>());
                    enemys.get(to).add(from);
                }
            }
            if (isFriends == 'F') {
                graph[from].add(to);
                graph[to].add(from);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
