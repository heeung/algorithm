package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14889 {
	
	static int N, min;
	static int[][] map;
	static boolean[] visited, check;
	static int[] score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N + 1];
		min = Integer.MAX_VALUE;
		combination(0, 2);
		System.out.println(min);
	}
	
	static void combination(int depth, int idx) {
		if (depth == N / 2) {
			score = new int[2];
			cal();
			min = Math.min(min, Math.abs(score[0] - score[1]));
			return ;
		}
		
		for (int i = idx; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(depth + 1, i);
				visited[i] = false;
			}
		}
	}
	
	static void cal() {
		int[] team1 = new int[N / 2];
		int[] team2 = new int[N / 2];
		
		int t1 = 0;
		int t2 = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				team1[t1++] = i - 1;
			if (!visited[i])
				team2[t2++] = i - 1;
		}
		check = new boolean[N / 2];
		sum(new int[2], team1, 0, 0);
		check = new boolean[N / 2];
		sum(new int[2], team2, 0, 1);
		
//		System.out.println(Arrays.toString(team1));
//		System.out.println(Arrays.toString(team2));
//		System.out.println();
	}

	static void sum(int[] comb, int[] team, int depth, int n) {
		if (depth == 2) {
			score[n] += map[comb[0]][comb[1]];
			return ;
		}
		
		for (int i = 0; i < N / 2; i++) {
			if (!check[i]) {
				check[i] = true;
				comb[depth] = team[i];
				sum(comb, team, depth + 1, n);
				check[i] = false;
			}
		}
	}
}
