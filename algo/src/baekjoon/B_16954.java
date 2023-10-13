package baekjoon;

import java.io.*;
import java.util.*;

public class B_16954 {
    static class Point {
        int i, j;

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static char[][] map;
    static ArrayList<Point> list;
    static int[] di = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') {
                    list.add(new Point(i, j));
                }
            }
        }

        bfs();
    }

    static void mapDown() {
        // 지우기
        for (Point cur : list) {
            map[cur.i][cur.j] = '.';
        }

        // 한칸 내리고 표시하기
        for (int i = 0; i < list.size(); i++) {
            list.get(i).i++;
            Point cur = list.get(i);

            if (cur.i <= 7) {
                map[cur.i][cur.j] = '#';
            } else {
                list.remove(i);
            }
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();

        Point start = new Point(7, 0);
        q.offer(start);

        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Point cur = q.poll();

                if (map[cur.i][cur.j] == '#') {
                    continue ;
                }
                for (int d = 0; d < 9; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];
                    if (ni >= 0 && nj >= 0 && ni < 8 && nj < 8) {
                        if (ni == 0 && nj == 7) {
                            System.out.println(1);
                            return;
                        }
                        if (map[ni][nj] != '#') {
                            q.offer(new Point(ni, nj));
                        }
                    }
                }
            }
            mapDown();
        }
        System.out.println(0);
    }
}
