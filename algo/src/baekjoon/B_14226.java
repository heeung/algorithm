package baekjoon;

import java.io.*;
import java.util.*;

public class B_14226 {
    static class Emoticon implements Comparable<Emoticon>{
        int clipBoard, num, cnt;

        public Emoticon(int clipBoard, int num, int cnt) {
            this.clipBoard = clipBoard;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Emoticon o) {
            return this.cnt - o.cnt;
        }
    }
    static int S, ret;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        visited = new boolean[10000][10000];

        if (S == 0) {
            System.out.println(1);
            return ;
        }
        bfs();
        System.out.println(ret);
    }

    static void bfs() {
//        Queue<Emoticon> q = new LinkedList<>();
        PriorityQueue<Emoticon> pq = new PriorityQueue<>();
        Emoticon start = new Emoticon(0, 1, 0);

        pq.offer(start);
        while(!pq.isEmpty()) {
            Emoticon cur = pq.poll();
            if (cur.num == S) {
                ret = cur.cnt;
                return ;
            }

            if (!visited[cur.num][cur.num]) {
                //클립보드에 복사만 한 것
                pq.offer(new Emoticon(cur.num, cur.num, cur.cnt + 1));
                visited[cur.num][cur.num] = true;
            }

            if (cur.num - 1 > -1 && !visited[cur.num - 1][cur.clipBoard]) {
//            if (cur.num - 1 > -1) {
                //하나 지운 것
                pq.offer(new Emoticon(cur.clipBoard, cur.num - 1, cur.cnt + 1));
                visited[cur.num - 1][cur.clipBoard] = true;
            }
            if (!visited[cur.num + cur.clipBoard][cur.clipBoard]) {
                //클립보드에 있는것을 붙여넣기 한 것
                pq.offer(new Emoticon(cur.clipBoard, cur.num + cur.clipBoard, cur.cnt + 1));
                visited[cur.num + cur.clipBoard][cur.clipBoard] = true;
            }
        }
    }
}
