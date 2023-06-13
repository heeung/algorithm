package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_벌꿀채취 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
//		@Override
//		public String toString() {
//			return "Point [i=" + i + ", j=" + j + "]";
//		}
	}
	static int N, M, C;
	static int[][] map;
	static Point[] points;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	static int cntFirstAmount, cntSecondAmount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			points = new Point[N * N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					points[i * N + j] = new Point(i, j);
				}
			}
			
			combination(new Point[2], 0, 0);
		}

	}
	
	public static void combination(Point[] comb, int depth, int idx) {
		
		if (idx > N * N)
			return ;
		
		if (depth == 2) {
			System.out.println(Arrays.toString(comb));
			visited = new boolean[N][N];
			visited[comb[0].i][comb[0].j] = true;
			visited[comb[1].i][comb[1].j] = true;
			cntFirstAmount = map[comb[0].i][comb[0].j];
			cntSecondAmount = map[comb[1].i][comb[1].j];
			dfs(comb[0], comb[1], 1, 1);
			return ;	
		}
		
		for (int i = idx; i < N * N; i++) {
			comb[depth] = points[i];
			combination(comb, depth + 1, i + 1);
		}
	}
	
	public static void dfs(Point first, Point second, int cntF, int cntS) {
		
		for (int d = 0; d < 4; d++) {
			Point next = new Point(first.i + dy[d], first.j + dx[d]);
			if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < N && !visited[next.i][next.j] 
					&& cntF <= M) {
				cntFirstAmount += map[next.i][next.j];
				if (cntFirstAmount > C) {
					cntFirstAmount -= map[next.i][next.j];
				}
				dfs(next, second, cntF + 1, cntS);
			}
		}
		
		if (cntF == M) {
			for (int d = 0; d < 4; d++) {
				Point next = new Point(second.i + dy[d], second.j + dx[d]);
				if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < N && !visited[next.i][next.j] 
						&& cntS <= M) {
					cntSecondAmount += map[next.i][next.j];
					if (cntSecondAmount > C) {
						cntSecondAmount -= map[next.i][next.j];
					}
					dfs(next, second, cntF, cntS + 1);
				}
			}
		}
	}

}
