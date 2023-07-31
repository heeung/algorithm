package baekjoon;

import java.io.*;
import java.util.*;

public class B_1600 {
    static class Point implements Comparable<Point> {
        int i, j, cnt, horseCnt;

        public Point(int i, int j, int cnt, int horseCnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.horseCnt = horseCnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
    static int K, H, W;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[] hdi = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] hdj = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
//        PriorityQueue<Point> q = new PriorityQueue<>();
        visited[0][0][0] = true;

        q.offer(new Point(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.i == H - 1 && cur.j == W - 1) {
                return cur.cnt;
            }
            // 정상 움직임
            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni >= 0 && nj >= 0 && ni < H && nj < W && !visited[ni][nj][cur.horseCnt]
                        && map[ni][nj] == 0) {
                    visited[ni][nj][cur.horseCnt] = true;
                    q.offer(new Point(ni, nj, cur.cnt + 1, cur.horseCnt));
                }
            }

            // 말 움직임
            for (int d = 0; d < 8; d++) {
                int ni = cur.i + hdi[d];
                int nj = cur.j + hdj[d];

                if (ni >= 0 && nj >= 0 && ni < H && nj < W && cur.horseCnt + 1 <= K && !visited[ni][nj][cur.horseCnt + 1]
                        && map[ni][nj] == 0) {
                    visited[ni][nj][cur.horseCnt + 1] = true;
                    q.offer(new Point(ni, nj, cur.cnt + 1, cur.horseCnt + 1));
                }
            }
        }
        return -1;
    }
}
