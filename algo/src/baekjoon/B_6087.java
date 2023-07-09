package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_6087 {
    static class Point implements Comparable<Point> {
        int i, j, cnt, dir;

        public Point(int i, int j, int cnt, int dir) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
    static int W, H, ret;
    static char[][] map;
    static int[][][] visited;
    static Point[] dest;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new int[4][H][W];
        map = new char[H][W];
        dest = new Point[2];
        ret = Integer.MAX_VALUE;

        int idx = 0;
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[k][i][j] = Integer.MAX_VALUE;
                }
                if (map[i][j] == 'C') {
                    dest[idx++] = new Point(i, j, 0, -1);
                }
            }
        }

//        visited[dest[0].i][dest[0].j] = 0;
//        bfs();

        System.out.println(bfs());
    }

    static int bfs() {
        int min = Integer.MAX_VALUE;
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.offer(dest[0]);
        Point cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (cur.i == dest[1].i && cur.j == dest[1].j) {
                min = Math.min(min, cur.cnt);
                continue ;
            }

            for (int d = 0; d < 4; d++) {
                if (d == 0 && cur.dir == 2) continue ;
                else if (d == 1 && cur.dir == 3) continue ;
                else if (d == 2 && cur.dir == 0) continue ;
                else if (d == 3 && cur.dir == 1) continue ;

                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                int nextMirrors = (cur.dir == d || cur.dir == -1) ? cur.cnt : cur.cnt + 1;

                if (ni >= 0 && nj >= 0 && ni < H && nj < W && map[ni][nj] != '*') {
                    if (visited[d][ni][nj] > nextMirrors) {
                        pq.offer(new Point(ni, nj, nextMirrors, d));
                        visited[d][ni][nj] = nextMirrors;
                    }
                }
            }
        }
        return min;
    }
}
