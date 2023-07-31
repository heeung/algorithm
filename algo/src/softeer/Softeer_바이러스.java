package softeer;

import java.io.*;
import java.util.*;

public class Softeer_바이러스 {
    static long K, P, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            K = (K * P) % 1000000007;
        }

        System.out.println(K % 1000000007);
    }
}
