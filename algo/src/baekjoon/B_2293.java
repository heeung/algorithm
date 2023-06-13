package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2293 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[K + 1];
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);
		for (int i = 0; i < N; i++) {
			for (int cost = 1; cost <= K; cost++) {
				if (cost >= coins[i]) {
					dp[cost] = dp[cost] + dp[cost - coins[i]];
					if (cost == coins[i])
						dp[cost]++;
				}
			}
		}
		System.out.println(dp[K]);
	}

}
