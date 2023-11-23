package baekjoon;

import java.io.*;
import java.util.*;

public class B_2096 {
    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[3];

        st = new StringTokenizer(br.readLine());
        map[0] = Integer.parseInt(st.nextToken());
        map[1] = Integer.parseInt(st.nextToken());
        map[2] = Integer.parseInt(st.nextToken());

        int[] curMinDp = Arrays.copyOf(map, 3);
        int[] curMaxDp = Arrays.copyOf(map, 3);
        int[] preMinDp = Arrays.copyOf(map, 3);
        int[] preMaxDp = Arrays.copyOf(map, 3);
//        if (N == 1) {
//            System.out.printf("%d %d\n",
//                    Math.max(Math.max(curMaxDp[0], curMaxDp[1]), curMaxDp[2]),
//                    Math.min(Math.min(curMinDp[0], curMinDp[1]), curMinDp[2])
//            );
//            return ;
//        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[0] = Integer.parseInt(st.nextToken());
            map[1] = Integer.parseInt(st.nextToken());
            map[2] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                if (j == 0) { // 0 번째 인덱스
                    curMaxDp[j] = map[j] + Math.max(preMaxDp[j], preMaxDp[j + 1]);
                    curMinDp[j] = map[j] + Math.min(preMinDp[j], preMinDp[j + 1]);
                } else if (j == 1) { // 1 번째 인덱스
                    curMaxDp[j] = map[j] + Math.max(Math.max(preMaxDp[j], preMaxDp[j + 1]), preMaxDp[j - 1]);
                    curMinDp[j] = map[j] + Math.min(Math.min(preMinDp[j], preMinDp[j + 1]), preMinDp[j - 1]);
                } else { // 2 번째 인덱스
                    curMaxDp[j] = map[j] + Math.max(preMaxDp[j], preMaxDp[j - 1]);
                    curMinDp[j] = map[j] + Math.min(preMinDp[j], preMinDp[j - 1]);
                }
            }
            for (int k = 0; k < 3; k++) {
                preMinDp[k] = curMinDp[k];
                preMaxDp[k] = curMaxDp[k];
            }
        }
        System.out.printf("%d %d\n",
                Math.max(Math.max(curMaxDp[0], curMaxDp[1]), curMaxDp[2]),
                Math.min(Math.min(curMinDp[0], curMinDp[1]), curMinDp[2])
        );
    }
}
