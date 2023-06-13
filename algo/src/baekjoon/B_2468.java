package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2468 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, maxHeight, cntSafe;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		maxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				maxHeight = Math.max(now, maxHeight);
			}
		}
		
		for (int h = 0; h < maxHeight; h++) {
			map = fill(h);
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						dfs(new Point(i, j));
						cnt++;
					}
				}
			}
			cntSafe = Math.max(cntSafe, cnt);
		}
		System.out.println(cntSafe);
	}
	
	public static void dfs(Point head) {
		visited[head.i][head.j] = true;
		
		for (int d = 0; d < 4; d++) {
			Point next = new Point(head.i + dy[d], head.j + dx[d]);
			if (next.i < N && next.j < N && next.i >= 0 && next.j >= 0 && !visited[next.i][next.j]
					&& map[next.i][next.j]!= 0) {
				dfs(next);
			}
		}
	}
	
	public static int[][] fill(int h) {
		int[][] ret = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= h) {
					ret[i][j] = 0;
				} else {
					ret[i][j] = map[i][j];
				}
			}
		}
		
		return ret;
	}
}
