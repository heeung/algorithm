package baekjoon;

import java.io.*;
import java.util.*;

public class B_21923 {
    static class Point implements Comparable<Point> {
        int i, j, cost;

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", cost=" + cost +
                    '}';
        }

        public Point(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point o) {
            return o.cost - this.cost;
        }
    }
    static int N, M, change, ret;
    static int[][] map;
    static int[][] upDp, downDp;
//    static boolean[][] visited;
    static int[] upDi = {1, 0};
    static int[] upDj = {0, 1};
    static int[] downDi = {1, 0};
    static int[] downDj = {0, -1};
    static Point start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        upDp = new int[N][M];
        downDp = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
//                dp[i][j] = Integer.MIN_VALUE;
            }
        }
//        start = new Point(0, 0, map[0][0]);
        bfs(new Point(0, 0, map[0][0]), upDi, upDj, upDp);
        bfs(new Point(0, 0, map[0][0]), upDi, upDj, upDp);
    }

    static void bfs(Point start, int[] di, int[] dj, int[][] sum) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean isDown = false;
        pq.offer(start);

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
//            System.out.println(cur);

            if (cur.i == 0 && cur.j == M - 1) {
                ret = cur.cost;
                return ;
            }

            if (isDown) {
                for (int d = 0; d < 2; d++) {
                    int ni = cur.i + downDi[d];
                    int nj = cur.j + downDj[d];

                    if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
                        
                    }
                }
            }
        }
    }
}
