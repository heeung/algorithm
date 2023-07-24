package softeer;

import java.io.*;
import java.util.*;

public class Softeer_슈퍼컴퓨터_클러스터 {
    static int N;
    static long B;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));

        long left = arr[0];
        long right = arr[N - 1] + (long)Math.sqrt(B);
        long ret = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid)) {
                left = mid + 1;
                ret = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ret);
    }

    static boolean check(long num) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] < num) {
                sum += (long)Math.pow(num - arr[i], 2);
                if (sum > B)
                    return false;
            }
        }
        return true;
    }
}