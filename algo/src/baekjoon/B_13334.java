package baekjoon;

import java.io.*;
import java.util.*;

public class B_13334 {
    static class Locale implements Comparable<Locale> {
        int start, end;
        public Locale(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Locale{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Locale o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    static int N, D, cnt, max;
    static PriorityQueue<Locale> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start < end) {
                pq.add(new Locale(start, end));
            } else {
                pq.add(new Locale(end, start));
            }
        }

        D = Integer.parseInt(br.readLine());

        //슬라이딩 윈도우 형태
        int left = pq.peek().start;
        int right = left + D;

        Queue<Integer> lq = new LinkedList<>();
        while (!pq.isEmpty()) {
            Locale now = pq.poll();

            if (Math.abs(now.end - now.start) > D) continue;

            if (right < now.end) {
                right = now.end;
                left = right - D;
            }

            while (!lq.isEmpty() && lq.peek() < left) {
                lq.poll();
                cnt--;
            }
            cnt++;
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
