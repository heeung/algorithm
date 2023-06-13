package baekjoon;

import java.io.*;
import java.util.*;

public class B_18430 {
	static int N, M, max;
	static int[][] map;
	static int[] di = {0, 1, 0, -1, 0};
	static int[] dj = {1, 0, -1, 0, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (N < 2 || M < 2) {
			System.out.println("0");
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				recur(i, j, 0);
//				cancel(i, j, 0);
//				System.out.println("---------------------------------");
			}
		}
//		recur(0, 0, 0);
		System.out.println(max);
	}
	
	static void recur(int x, int y, int sum) {
		max = Math.max(max, sum);
		
		for (int i = x; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < 4; d++) {
					int p = pick(i, j, d);
					
//					System.out.println("d:" + d + " i : " + i + " " + "j : " + j);
//					System.out.println(sum + p);
					if (p != 0) {
						recur(i, j, sum + p);
						cancel(i, j, d);
//						sum = sum - p;
					}
				}
			}
		}
	}
	
	static int pick(int i, int j, int dir) { //dir는 3까지 들어간다.
		int i1 = i + di[dir];
		int j1 = j + dj[dir];
		int i2 = i + di[dir + 1];
		int j2 = j + dj[dir + 1];
		
		int sum = 2 * map[i][j];
		if (i1 >= 0 && j1 >= 0 && i2 >= 0 && j2 >= 0
				&& i1 < N && j1 < M && i2 < N && j2 < M
				&& !visited[i][j] && !visited[i1][j1] && !visited[i2][j2]) {
			visited[i][j] = true;
			visited[i1][j1] = true;
			visited[i2][j2] = true;
			sum += map[i1][j1];
			sum += map[i2][j2];
//			System.out.println(i  + " " + j + i);
			return sum;
		}
		return 0;
	}
	
	static void cancel(int i, int j, int dir) {
		int i1 = i + di[dir];
		int j1 = j + dj[dir];
		int i2 = i + di[dir + 1];
		int j2 = j + dj[dir + 1];
		
		visited[i][j] = false;
		visited[i1][j1] = false;
		visited[i2][j2] = false;
	}
}
