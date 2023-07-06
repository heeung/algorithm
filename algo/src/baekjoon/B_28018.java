package baekjoon;

import java.io.*;
import java.util.*;

public class B_28018 {
	static int N, Q;
	static int[] time = new int[1000002];
	static int[] sum = new int[1000002];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
//			for (int j = s; j <= e; j++) {
//				time[j]++;
//			}
			time[s]++;
			time[e + 1]--;
		}
		
		for (int i = 1; i < 1000002; i++) {
			sum[i] = sum[i - 1] + time[i];
		}
		
		StringBuffer sb = new StringBuffer();
		Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int t = Integer.parseInt(st.nextToken());
			
			sb.append(sum[t] + "\n");
		}
		System.out.println(sb);
	}
}
