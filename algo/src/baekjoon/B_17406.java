package baekjoon;

import java.io.*;
import java.util.*;

public class B_17406 {
	static int N, M, T, min;
	static int[][] map, arr, reference;
	static int[] order;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		reference = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				reference[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order = new int[T];
		visited = new boolean[T];
		arr = new int[T][3];
		
		min = Integer.MAX_VALUE;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			arr[i][0] = r;
			arr[i][1] = c;
			arr[i][2] = s;
			
//			map = change(r - 1, c - 1, s);
		}
		
		combination(new int[T], 0);
//		for (int i = 0; i < N; i++) {
//			int sum = 0;
//			for (int j = 0; j < M; j++) {
//				sum += map[i][j];
//			}
//			min = Math.min(min, sum);
//		}
		
		System.out.println(min);
	}
	
	static void combination(int[] comb, int depth) {
		if (depth == T) {
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = reference[i][j];
				}
			}
			for (int i = 0; i < T; i++) {
				map = change(arr[comb[i]][0] - 1, arr[comb[i]][1] - 1, arr[comb[i]][2]);
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
//				System.out.println("sum: " + sum);
				min = Math.min(min, sum);
			}
//			System.out.println(Arrays.toString(comb));
//			System.out.println(min);
			return ;
		}
		
		for (int i = 0; i < T; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = i;
				combination(comb, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static int[][] change(int r, int c, int s) {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for (int i = 1; i <= s; i++) {
			tmp = swap(r, c, i, tmp);
		}
		
		return tmp;
	}
	
	static int[][] swap(int r, int c, int s, int[][] tmp) {
		int left_up = map[r - s + 1][c - s]; // 왼쪽위 모퉁이가 될 수
		int right_up = map[r - s][c + s - 1]; // 왼쪽위 모퉁이가 될 수
		int left_down = map[r + s][c - s + 1]; // 왼쪽위 모퉁이가 될 수
		int right_down = map[r + s - 1][c + s]; // 왼쪽위 모퉁이가 될 수
		
		for (int j = 1; j <= s * 2 - 1; j++) { // 상하
			tmp[r - s][c - s + j] = map[r - s][c - s + j - 1];
			tmp[r + s][c - s + j] = map[r + s][c - s + j + 1];
		}
		for (int i = 1; i <= s * 2 - 1; i++) { // 좌우
			tmp[r - s + i][c + s] = map[r - s + i - 1][c + s];
			tmp[r - s + i][c - s] = map[r - s + i + 1][c - s];
		}
		
		tmp[r - s][c - s] = left_up;
		tmp[r - s][c + s] = right_up;
		tmp[r + s][c - s] = left_down;
		tmp[r + s][c + s] = right_down;
		
		return tmp;
	}
}