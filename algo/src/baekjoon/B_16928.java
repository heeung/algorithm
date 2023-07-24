package baekjoon;

import java.io.*;
import java.util.*;

public class B_16928 {
    static int N, M, ret;
    static boolean[] visited;
    static HashMap<Integer, Integer> info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new HashMap<>();
        visited = new boolean[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            info.put(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            info.put(x, y);
        }

        bfs();
        System.out.println(ret);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            ret++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = cur + j;
                    if (next == 100) return ;

                    if (next > 100) continue ;
                    if (!visited[next] && next <= 100) {
                        visited[next] = true;
                        if (info.containsKey(next)) {
                            next = info.get(next);
                        }
                        q.add(next);
                    }
                }
            }
        }
    }
}
