package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_20057 {
	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int outCnt;
	static int ret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				ret += map[i][j];
			}
		}

		tornado();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret -= map[i][j];
			}
		}
		System.out.println(ret);
	}

	public static void tornado() {
		Point dot = new Point(N / 2, N / 2);
		int d = 0;
		int t = 1;
		while (true) {
			for (int a = 0; a < t; a++) {
				int nextI = dot.i + dy[d % 4];
				int nextJ = dot.j + dx[d % 4];
				// 로직
				move(nextI, nextJ, d);
				dot = new Point(nextI, nextJ);
			}
			d++;
			for (int a = 0; a < t; a++) {
				int nextI = dot.i + dy[d % 4];
				int nextJ = dot.j + dx[d % 4];
				// 로직
				move(nextI, nextJ, d);
				dot = new Point(nextI, nextJ);
			}
			d++;
			if (t == N - 1)
				break ;
			t++;
		}
		for (int a = 0; a < t; a++) {
			int nextI = dot.i + dy[d % 4];
			int nextJ = dot.j + dx[d % 4];
			// 로직
			move(nextI, nextJ, d);
			dot = new Point(nextI, nextJ);
		}
	}

	public static void move(int i, int j, int d) {
		int sand = map[i][j];
		map[i][j] = 0;
		int cnt = 0;
		int dir = d % 4;
		if (dir == 0) {
			// 1
			if (j - 2 >= 0)
				map[i][j - 2] += sand * 5 / 100;
				cnt += sand * 5 / 100;
			// 2
			if (j - 1 >= 0 && i - 1 >= 0)
				map[i - 1][j - 1] += sand / 10;
				cnt += sand / 10;
			// 3
			if (j - 1 >= 0 && i + 1 < N)
				map[i + 1][j - 1] += sand / 10;
				cnt += sand / 10;
			// 5
			if (i - 2 >= 0)
				map[i - 2][j] += sand * 2 / 100;
				cnt += sand * 2 / 100;
			// 6
			if (i - 1 >= 0)
				map[i - 1][j] += sand * 7 / 100;
				cnt += sand * 7 / 100;
			// 7
			if (i - 1 >= 0 && j + 1 < N)
				map[i - 1][j + 1] += sand / 100;
				cnt += sand / 100;
			// 8
			if (i + 2 < N)
				map[i + 2][j] += sand * 2 / 100;
				cnt += sand * 2 / 100;
			// 9
			if (i + 1 < N)
				map[i + 1][j] += sand * 7 / 100;
				cnt += sand * 7 / 100;
			// 10
			if (i + 1 < N && j + 1 < N)
				map[i + 1][j + 1] += sand / 100;
				cnt += sand / 100;
			// 4
			if (j - 1 >= 0) {
				map[i][j - 1] += sand - cnt;
			}
		} else if (dir == 1) {
			// 1
			if (j - 2 >= 0)
				map[i][j - 2] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 2
			if (j - 1 >= 0 && i - 1 >= 0)
				map[i - 1][j - 1] += sand / 100;
			cnt += sand / 100;
			// 3
			if (j - 1 >= 0 && i + 1 < N)
				map[i + 1][j - 1] += sand / 10;
			cnt += sand / 10;
			// 4
			if (j - 1 >= 0)
				map[i][j - 1] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			if (i - 1 >= 0 && j + 1 < N)
				map[i - 1][j + 1] += sand / 100;
			cnt += sand / 100;
			// 8
			if (i + 2 < N)
				map[i + 2][j] += sand * 5 / 100;
			cnt += sand * 5 / 100;
			// 10
			if (i + 1 < N && j + 1 < N)
				map[i + 1][j + 1] += sand / 10;
			cnt += sand / 10;
			// 11
			if (j + 1 < N)
				map[i][j + 1] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			// 12
			if (j + 2 < N)
				map[i][j + 2] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 9
			if (i + 1 < N)
				map[i + 1][j] += sand - cnt;
			outCnt += sand - cnt;
		} else if (dir == 2) {
			// 2
			if (j - 1 >= 0 && i - 1 >= 0)
				map[i - 1][j - 1] += sand / 100;
			cnt += sand / 100;
			// 3
			if (j - 1 >= 0 && i + 1 < N)
				map[i + 1][j - 1] += sand / 100;
			cnt += sand / 100;
			// 5
			if (i - 2 >= 0)
				map[i - 2][j] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 6
			if (i - 1 >= 0)
				map[i - 1][j] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			// 7
			if (i - 1 >= 0 && j + 1 < N)
				map[i - 1][j + 1] += sand / 10;
			cnt += sand / 10;
			// 8
			if (i + 2 < N)
				map[i + 2][j] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 9
			if (i + 1 < N)
				map[i + 1][j] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			// 10
			if (i + 1 < N && j + 1 < N)
				map[i + 1][j + 1] += sand / 10;
			cnt += sand / 10;
			// 12
			if (j + 2 < N)
				map[i][j + 2] += sand * 5 / 100;
			cnt += sand * 5 / 100;
			// 11
			if (j + 1 < N)
				map[i][j + 1] += sand - cnt;
		} else if (dir == 3) {
			// 1
			if (j - 2 >= 0)
				map[i][j - 2] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 2
			if (j - 1 >= 0 && i - 1 >= 0)
				map[i - 1][j - 1] += sand / 10;
			cnt += sand / 10;
			// 3
			if (j - 1 >= 0 && i + 1 < N)
				map[i + 1][j - 1] += sand / 100;
			cnt += sand / 100;
			// 4
			if (j - 1 >= 0)
				map[i][j - 1] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			// 5
			if (i - 2 >= 0)
				map[i - 2][j] += sand * 5 / 100;
			cnt += sand * 5 / 100;
			// 7
			if (i - 1 >= 0 && j + 1 < N)
				map[i - 1][j + 1] += sand / 10;
			cnt += sand / 10;
			// 10
			if (i + 1 < N && j + 1 < N)
				map[i + 1][j + 1] += sand / 100;
			cnt += sand / 100;
			// 11
			if (j + 1 < N)
				map[i][j + 1] += sand * 7 / 100;
			cnt += sand * 7 / 100;
			// 12
			if (j + 2 < N)
				map[i][j + 2] += sand * 2 / 100;
			cnt += sand * 2 / 100;
			// 6
			if (i - 1 >= 0)
				map[i - 1][j] += sand - cnt;
		}
	}

}
