package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_3687 {
    static long[] dp;
    static int [] arr= {1,7,4,2,0,8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new long[101];
        dpInit();

        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(dp[num]);
            sb.append(" ");
            sb.append(bigest(num));

            System.out.println(sb.toString());
        }
    }

    static String bigest(int num) {
        StringBuilder sb = new StringBuilder();

        if (num % 2 == 0) { // 나눠 떨어지면 걍 1 다 떄려박기
            for (int i = 0; i < num / 2; i++) {
                sb.append("1");
            }
        } else { // 홀수면 3개로 만들 수 있는거 중 가장 큰게 7
            sb.append("7");
            for (int i = 0; i < (num - 3) / 2; i++) {
                sb.append("1");
            }
        }

        return sb.toString();
    }

    static void dpInit() {
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;

        for(int i = 9; i <= 100; i++){
            for(int j = 2; j <= 7; j++){
                String temp = String.valueOf(dp[i - j]) + String.valueOf(arr[j - 2]);
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }
    }
}
