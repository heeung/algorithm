package baekjoon;

import java.io.*;
import java.util.*;

public class B_1461 {
    static int N, M, ret;
    static PriorityQueue<Integer> minusQ, plusQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minusQ = new PriorityQueue<>();
        plusQ = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur < 0) minusQ.offer(cur);
            else plusQ.offer(cur);
        }

        solve();
        System.out.println(ret);
    }

    static void solve() {
        ArrayList<Integer> tmp = new ArrayList<>();

        while (!minusQ.isEmpty() || !plusQ.isEmpty()) {
            int left = Math.abs(minusQ.peek() == null ? 0 : minusQ.peek());
            int right = Math.abs(plusQ.peek() == null ? 0 : plusQ.peek());

            if (left > right) {
                tmp.add(left);
                for (int i = 0; i < M; i++) {
                    if (minusQ.isEmpty()) break;
                    minusQ.poll();
                }
            } else {
                tmp.add(right);
                for (int i = 0; i < M; i++) {
                    if (plusQ.isEmpty()) break;
                    plusQ.poll();
                }
            }
        }

        for (int cur : tmp) {
            ret += cur * 2;
        }

        ret -= tmp.get(0);
    }
}
