package baekjoon;

import java.io.*;
import java.util.*;

public class B_5052 {
    static int N;
    static HashSet<String> set;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            set = new HashSet<>();
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String cur = br.readLine();
                set.add(cur);
                list.add(cur);
            }

            Collections.sort(list);

            boolean isContained = false;
            Loop:
            for (int i = 0; i < N; i++) {
                String cur = list.get(i);

                for (int j = 1; j < cur.length(); j++) {
                    if (set.contains(cur.substring(0, j))) {
                        isContained = true;
                        break Loop;
                    }
                }
            }
            if (isContained)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        ArrayList<int[]> keys = new ArrayList<>();
        Collections.sort(keys, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();

//    ArrayList<int[]> ret = new ArrayList<>();
    }
}
