package baekjoon;

import java.io.*;
import java.util.*;

public class B_14500 {
	static int N, M, max;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 5][M + 5];
		
		for (int i = 2; i < N + 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 2; j < M + 2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		checkAll();
		
		System.out.println(max);
	}
	
	static void checkAll() {
		for (int i = 2; i < N + 2; i++) {
			for (int j = 2; j < M + 2; j++) {
				check_1(i, j);
				check_2(i, j);
				check_3(i, j);
				check_4(i, j);
				check_5(i, j);
			}
		}
	}
	
	static void check_1(int i, int j) { // 첫번째 모양
		int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
		max = Math.max(max, sum);
	}
	
	static void check_2(int i, int j) {
		int sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
		max = Math.max(max, sum);
	}
	
	static void check_3(int i, int j) {
		int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j - 1];
		max = Math.max(max, sum);
		
		
		sum = map[i][j] + map[i - 1][j] + map[i - 2][j] + map[i - 2][j + 1];
		max = Math.max(max, sum);

		sum = map[i][j] + map[i - 1][j] + map[i - 2][j] + map[i - 2][j - 1];
		max = Math.max(max, sum);


		sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
		max = Math.max(max, sum);

		sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 2];
		max = Math.max(max, sum);


		sum = map[i][j] + map[i][j - 1] + map[i][j - 2] + map[i + 1][j - 2];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i][j - 1] + map[i][j - 2] + map[i - 1][j - 2];
		max = Math.max(max, sum);
	}
	
	static void check_4(int i, int j) {
		int sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j - 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 1][j + 2];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
		max = Math.max(max, sum);
	}
	
	static void check_5(int i, int j) {
		int sum = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j + 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
		max = Math.max(max, sum);
		
		sum = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i + 1][j];
		max = Math.max(max, sum);
	}
}
