package baekjoon;


import java.util.*;
import java.io.*;

public class B_1525 {
//    static int[][] map;
    static HashMap<String, Integer> sequences;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {-1, 0, 1 ,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[3][3];
        int[] index = new int[2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        // 모든 경우를 탐색
        Queue<String> q = new LinkedList<>();
        Queue<int[]> indexOfZero = new LinkedList<>();
        sequences = new HashMap<>();
        q.offer(parseString(map));
        sequences.put(parseString(map), 0);
        indexOfZero.offer(index);
        while (!q.isEmpty()) {
            String now = q.poll();
            int cnt = sequences.get(now);

            int[][] curMap = parseMap(now);
            int[] curIndexOfZero = indexOfZero.poll();
            int i = curIndexOfZero[0];
            int j = curIndexOfZero[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni >= 0 && nj >= 0 && ni < 3 && nj < 3) {
                    // 교환
                    int num_1 = curMap[i][j];
                    int num_2 = curMap[ni][nj];
                    curMap[ni][nj] = num_1;
                    curMap[i][j] = num_2;
                    String next = parseString(curMap);
                    if(!sequences.containsKey(next)){
                        q.offer(next);
                        int[] k = {ni, nj};
                        indexOfZero.offer(k);
                        sequences.put(next, cnt + 1);
                    }
                    // 다음을 위해 돌려놓기
                    curMap[ni][nj] = num_2;
                    curMap[i][j] = num_1;
                }
            }
        }
        if (sequences.containsKey("123456780")){
            System.out.println(sequences.get("123456780"));
        } else {
            System.out.println(-1);
        }
    }

    static String parseString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }

    static int[][] parseMap(String str) {
        int[][] map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int idx = 3 * i + j;
                map[i][j] = Integer.parseInt(str.substring(idx, idx + 1));
            }
        }
        return map;
    }
}
