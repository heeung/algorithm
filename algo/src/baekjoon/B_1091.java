package baekjoon;

import java.io.*;
import java.util.*;

public class B_1091 {
    static int N, cnt;
    static int[] S, P, cards, preCards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];
        cards = new int[N];
        preCards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            cards[i] = i;
            preCards[i] = i;
        }

        while (!check()) {
            // 섞고있음에도 불구하고 처음과 같은게 나와버리면 계속 순환된다는 의미임
            if (cnt != 0 && Arrays.equals(cards, preCards)) {
                System.out.println("-1");
                return ;
            }
            cnt += 1;
            shuffle();
        }

        System.out.println(cnt);
    }

    static void shuffle() {
        int[] tmp = new int[N];
        for (int i =0; i < N; i++) {
            tmp[S[i]] = cards[i];
        }
        cards = tmp.clone();
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            int now = cards[i];
            if (P[now] != i % 3) {
                return false;
            }
        }
        return true;
    }
}

/*

0 1 2

결국 1 2 0 이 되어야 함

0 1 2
2 0 1
1 2 0

초기 상태
0 -> 0, 3, 6, 9
1 -> 1, 4, 7, 10
2 -> 2, 5, 8, 11

목표 상태
0 -> 3, 5, 7, 11
1 -> 0, 1, 6, 10
2 -> 2, 4, 8, 9

 */