package baekjoon;

import java.io.*;
import java.util.*;

public class B_2166 {
    static class Point {
        long i, j;

        public Point(long i, long j) {
            this.i = i;
            this.j = j;
        }
    }
    static int N;
    static ArrayList<Point> dots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dots = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots.add(new Point(x, y));
        }
        dots.add(dots.get(0));

        long sum_a = 0, sum_b = 0;
        for (int i = 0; i < N; i++) {
            sum_a += dots.get(i).i * dots.get(i + 1).j;
            sum_b += dots.get(i + 1).i * dots.get(i).j;
        }

        System.out.printf("%.1f\n", (Math.abs(sum_a - sum_b) / 2.0));
    }
}
