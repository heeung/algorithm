package baekjoon;

import java.io.*;
import java.util.*;

public class B_17244 {
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    static Character[][] map;
    static int N, M, min;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static ArrayList<Point> arr;
    static boolean[] combVisited;
    static boolean[][] visited;
    static Point start, end;
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Character[M][N];
        arr = new ArrayList<>();
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'X') arr.add(new Point(i, j));
                if (map[i][j] == 'S') start = new Point(i, j);
                if (map[i][j] == 'E') end = new Point(i, j);
            }
        }

        min = Integer.MAX_VALUE;
        combVisited = new boolean[arr.size()];
        combination(new Point[arr.size()], 0);
        System.out.println(min);
    }

    static void combination(Point[] comb, int depth) {
        if (depth == comb.length) {
            int now = bfs(comb);
            min = Math.min(now, min);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!combVisited[i]) {
                combVisited[i] = true;
                comb[depth] = arr.get(i);
                combination(comb,depth + 1);
                combVisited[i] = false;
            }
        }
    }

    static int bfs(Point[] comb) {
        int idx = 0;
        Point curStart = start;
        int ret = 0;
        while (idx < comb.length) {
            q.clear();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = false;
                }
            }
//            visited = new boolean[M][N];
            // 목적지는 comb[idx]
            q.offer(curStart);
            int cnt = 0;
            Loop:
            while(!q.isEmpty()) {
//                ArrayList<Point> list = new ArrayList<>();
                list.clear();
                while (!q.isEmpty()) {
                    Point tmp = q.poll();
                    if (tmp.i == comb[idx].i && tmp.j == comb[idx].j) {
                        curStart = tmp;
                        ret += cnt;
                        idx++;
                        break Loop;
                    }
                    list.add(tmp);
                }
                for (Point cur : list) {
                    for (int d = 0; d < 4; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];
                        if (ni >= 0 && nj >= 0 && ni < M && nj < N && !visited[ni][nj] && map[ni][nj] != '#') {
                            visited[ni][nj] = true;
                            Point next = new Point(ni, nj);
                            q.offer(next);
                        }
                    }
                }
                cnt++;
            }
        }
        q.clear();
//        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
        // 목적지는 comb[idx]
        q.offer(curStart);
        int cnt = 0;
        Loop1:
        while(!q.isEmpty()) {
//            ArrayList<Point> list = new ArrayList<>();
            list.clear();
            while (!q.isEmpty()) {
                Point tmp = q.poll();
                if (tmp.i == end.i && tmp.j == end.j) {
                    ret += cnt;
                    break Loop1;
                }
                list.add(tmp);
            }
            for (Point cur : list) {
                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];
                    if (ni >= 0 && nj >= 0 && ni < M && nj < N && !visited[ni][nj] && map[ni][nj] != '#') {
                        visited[ni][nj] = true;
                        Point next = new Point(ni, nj);
                        q.offer(next);
                    }
                }
            }
            cnt++;
        }
        return ret;
    }
}
