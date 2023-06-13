package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_1010 {
	
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[31][31];
		for (int i = 1; i <= 30; i++) {
            dp[i][1] = i;
        }

        for (int j = 2; j <= 30; j++) {
            for (int k = 2; k <= 30; k++) {
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
            }
        }
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[M][N]);
		}
	}
}
