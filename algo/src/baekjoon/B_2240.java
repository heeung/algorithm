package baekjoon;

import java.io.*;
import java.util.*;

public class B_2240 {
	static int T, W;
	static int[] treeNums;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		treeNums = new int[T + 1];
		dp = new int[T + 1][W + 1];
		
		for (int i = 1; i <= T; i++) {
			treeNums[i] = Integer.parseInt(br.readLine());
		}
		
		solve();
		
		int ret = 0;
		for (int i = 0; i <= W; i++) {
			ret = Math.max(ret, dp[T][i]);
		}
		
		System.out.println(ret);
	}

	static void solve() {
		for (int i = 1; i <= T; i++) {
			// 한번도 움직이지 않는 경우의수 칸 채울 것
			// 1이면 받아 먹고, 아니면 못받지.
			dp[i][0] = (treeNums[i] == 1) ? dp[i - 1][0] + 1 : dp[i - 1][0];
			
			// 가능한 움직임 횟수
			int possibleMove = (i < W) ? i : W;
			for (int j = 1; j <= possibleMove; j++) {
				int plum = 0;
				// 움직임이 홀수 번째는 2여야 먹을수 있고.
				// 움직임이 짝수 번째는 1이여야 먹을수 있고.
				// 그게 아닌 경우 못먹는다.
				if ((treeNums[i] == 2 && j % 2 == 1) || (treeNums[i] == 1 && j % 2 == 0)) {
					plum = 1;
				}
				
				// 해당 시퀀스에 움직였냐 안움직였냐를 판단, 최대를 유지
				int change = dp[i - 1][j - 1] + plum;
				int notChange = dp[i - 1][j] + plum;
				dp[i][j] = Math.max(change, notChange);
			}
		}
	}
}
