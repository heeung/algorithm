package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2573 {
	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N, M, cnt, year;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			cnt = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						cnt++;
						dfs(new Point(i, j));
					}
				}
			}
			if (cnt >= 2) {
				break ;
			}
			map = melt();
			if (map != null)
				year++;
			else {
				System.out.println("0");
				return ;
			}
		}
		System.out.println(year);
	}

	public static void dfs(Point head) {
		visited[head.i][head.j] = true;

		for (int d = 0; d < 4; d++) {
			Point next = new Point(head.i + dy[d], head.j + dx[d]);
			if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < M && map[next.i][next.j] != 0
					&& !visited[next.i][next.j]) {
				dfs(next);
			}
		}
	}

	public static int[][] melt() {
		int cntZero = 0;
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					newMap[i][j] = 0;
					cntZero++;
				} else {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nextI = i + dy[d];
						int nextJ = j + dx[d];
						if (map[nextI][nextJ] == 0) {
							cnt++;
						}
					}
					newMap[i][j] = map[i][j] >= cnt ? map[i][j] - cnt : 0;
				}
			}
		}
		if (cntZero == N * M) {
			return null;
		}
		return newMap;
	}
}
