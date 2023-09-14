package baekjoon;

import java.io.*;
import java.util.*;

public class B_21924 {
    static class Node implements Comparable<Node> {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "from = " + from +
                    ", to = " + to +
                    ", cost = " + cost;
        }
    }
    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            q.offer(new Node(from, to, cost));
            sum += cost;
        }

        long ret = 0;
        // 크루스칼
        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 사이클이 존재하지 않을 경우만 간선 선택
            if (find(cur.from) != find(cur.to)) {
//                System.out.println("[ 선택된 간선 ]");
//                System.out.println(cur);

                union(cur.from, cur.to);

                ret += cur.cost;
//                System.out.println("<각 노드가 가리키고 있는 부모>");
//                System.out.println(Arrays.toString(parent) + "\n");
            }
        }

        for (int i = 1; i <= N; i++) {
            if (find(i) != 1) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(sum - ret);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }
}
