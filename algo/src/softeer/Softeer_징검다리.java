package softeer;

import java.io.*;
import java.util.*;


// 개울을 지난다, 즉 첫번째와 마지막이 꼭 포함되어야 하나?
// 그냥 오른쪽 봤을때 높아지는거 개수 세기?
// -> LIS
public class Softeer_징검다리 {
	static int[] map, dp;
	static int N, ret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (map[i] > map[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ret = Math.max(ret, dp[i]);
		}
		System.out.println(ret);
	}
}
