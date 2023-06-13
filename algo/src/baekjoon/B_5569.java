package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5569 {
	static int[][][] dp;
	static int W, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		/*
		 * 가지고 가야할 정보 : 1. 방향, 2. 바로 전에 턴 했냐 안했냐
		 * 0. 오른쪽인데 턴 안함.
		 * 1. 오른쪽인데 턴 함.
		 * 2. 위쪽인데 턴 안함.
		 * 3. 위쪽인데 턴 함.
		 * => 3차원 설계
		 */
		dp = new int[W][H][4];
		// 초기에는 꺾지 않은 경우로 모두 넣어주기
		for (int i = 0; i < H; i++) {
			dp[0][i][2] = 1;
		}
		for (int i = 0; i < W; i++) {
			dp[i][0][0] = 1;
		}
		
		for (int i = 1; i < W; i++) {
			for (int j = 1; j < H; j++) {
				dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % 100000;
				dp[i][j][1] = dp[i - 1][j][2] % 100000;
				dp[i][j][2] = (dp[i][j - 1][2] + dp[i][j - 1][3]) % 100000;
				dp[i][j][3] = dp[i][j - 1][0] % 100000;
			}
		}
		
		System.out.println((dp[W - 1][H - 1][0] + dp[W - 1][H - 1][1]
				+ dp[W - 1][H - 1][2] + dp[W - 1][H - 1][3]) % 100000);
	}

}
