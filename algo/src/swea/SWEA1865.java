package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1865 {
	static double[][] map;
	static boolean[] check;
	static int N;
	static double max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new double[N][N];
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = (double) Integer.parseInt(st.nextToken()) / 100;
				}
			}
			
			max = 0.0;
			dfs(0, 1.0);
			System.out.printf("#%d %.6f", t, max);
			System.out.println();
		}

	}
	
	public static void dfs(int depth, double sum) {
		if (sum * 100 <= max)
			return;
		
		if (depth == N) {
			if (sum * 100 > max) {
				max = sum * 100;
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(depth + 1, sum * map[depth][i]);
				check[i] = false;
			}
		}
	}
}
