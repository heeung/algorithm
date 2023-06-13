package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17070 {

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static int[][] cntArr;

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
		visited = new boolean[N][N];
		cntArr = new int[N][N];
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	public static void dfs(int i, int j, int dir) {
		for (int d = 0; d < 3; d++) {
			if (dir == 0 && d == 2)
				continue;
			else if (dir == 2 && d == 0)
				continue;
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			Point next = new Point(nextI, nextJ);
			if (d != 1) {
				if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && !visited[nextI][nextJ]
						&& map[nextI][nextJ] == 0) {
					visited[nextI][nextJ] = true;
					if (next.i == N - 1 && next.j == N - 1)
						cnt++;
					dfs(next.i, next.j, d);
					visited[nextI][nextJ] = false;
				}
			} else {
				if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && !visited[nextI][nextJ]
						&& map[nextI][nextJ] == 0 && map[nextI - 1][nextJ] == 0 && map[nextI][nextJ - 1] == 0) {
					visited[nextI][nextJ] = true;
					if (next.i == N - 1 && next.j == N - 1)
						cnt++;
					dfs(next.i, next.j, d);
					visited[nextI][nextJ] = false;
				}
			}
		}
	}
}