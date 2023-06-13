package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_가능한_시험_점수 {
	static int N, ret, sum;
	static int[] points;
	static int[] scores;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			points = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i] = Integer.parseInt(st.nextToken());
			}
			
			ret = 0;
			scores = new int[10001];
			for (int select = 1; select <= N; select++) {
				sum = 0;
				combination(new int[select], 0, select, 0);
			}
			for (int i = 0; i <= 10000; i++) {
				if (scores[i] > 0) {
					ret++;
				}
			}

			System.out.printf("#%d %d\n", t, ret + 1);
			
		}
	}
	
	public static void combination(int[] comb, int depth, int maxCnt, int idx) {
		
		if (depth == maxCnt) {
//			System.out.println(Arrays.toString(comb));
			if (scores[sum] > 0)
				return ;
			else
				scores[sum]++;
//			sum = 0;
			return ;
		}
		
		for (int i = idx; i < N; i++) {
			comb[depth] = points[i];
			sum += points[i];
			combination(comb, depth + 1, maxCnt, i + 1);
			sum -= points[i];
		}
	}
	
//	public static void solve(int[] score) {
//		int sum = 0;
//		for (int i = 0; i < score.length; i++) {
//			sum += score[i];
//		}
//		scores[sum]++;
//	}
}
