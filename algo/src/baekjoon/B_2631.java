package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2631 {
	
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		dp[0] = 1;

        int ans = 0;
        for(int i = 1; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) { // 오르막길 판단하기
                if(arr[i] > arr[j])
                	dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N - ans);
        System.out.println(Arrays.toString(dp));
	}

}
