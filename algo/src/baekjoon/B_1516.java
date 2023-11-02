package baekjoon;

import java.io.*;
import java.util.*;

public class B_1516 {
    static class Game {
        int cost, cnt;
        HashSet<Integer> set;

        public Game(int cost, int cnt) {
            this.cost = cost;
            this.cnt = cnt;
            this.set = new HashSet<>();
        }
    }
    static int[] rets;
    static Game[] games;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        rets = new int[N + 1];
        games = new Game[N + 1];
        for (int i = 1; i <= N; i++) {
            games[i] = new Game(0, 0);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            games[i].cost = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            while (cur != -1) {
                games[i].cnt++;
                games[cur].set.add(i);
                cur = Integer.parseInt(st.nextToken());
            }
        }

        HashSet<Integer> nums = new HashSet<>();
        while (true) {
            nums.clear();
            for (int i = 1; i <= N; i++) {
                if (games[i].cnt == 0) {
                    games[i].cnt = -1;
                    nums.add(i);
                }
            }
            if (nums.size() == 0) {
                break ;
            }
            for (Integer i : nums) {
                Game now = games[i];
                rets[i] = rets[i] + now.cost;
                for (Integer dest : now.set) {
                    rets[dest] = rets[i];
                    games[dest].cnt--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(rets[i]);
        }
    }
}
