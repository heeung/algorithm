package baekjoon;

import java.io.*;
import java.util.*;

public class B_28017 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[m];
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int[] curDp = new int[m];
            for (int i = 0; i < m; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (i == j) continue;

                    min = Math.min(min, dp[j]);
                }

                curDp[i] = Integer.parseInt(st.nextToken()) + min;
            }
            dp = curDp;
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
        	ret = Math.min(ret, dp[i]);
        }
        
        System.out.println(ret);
	}
}
