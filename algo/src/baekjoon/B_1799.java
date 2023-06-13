package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1799 {

	static int N, max;
	static int[][] map;
	static boolean[][] bishop;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		bishop = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < N * N; i++)
			combination(0, 0);
		System.out.println(max);
	}

	public static void combination(int idx, int cnt) {
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(bishop[i]));
//		}

//		if (idx == N * N) {
//			System.out.println(cnt);
			max = Math.max(max, cnt);
//			return;
//		}

		for (int n = idx; n < N * N; n++) {
			if (check(n / N, n % N)) {
				bishop[n / N][n % N] = true;
				cnt++;
				combination(n + 1, cnt);
				cnt--;
				bishop[n / N][n % N] = false;
			}
		}
	}

	public static boolean check(int i, int j) {
		if (map[i][j] == 0)
			return false;

		int x = i;
		int y = j;
		while (x >= 0 && y >= 0) {
			if (bishop[x][y])
				return false;
			x--;
			y--;
		}
		x = i;
		y = j;
		while (x >= 0 && y < N) {
			if (bishop[x][y])
				return false;
			x--;
			y++;
		}
		x = i;
		y = j;
		while (x < N && y < N) {
			if (bishop[x][y])
				return false;
			x++;
			y++;
		}
		x = i;
		y = j;
		while (x < N && y >= 0) {
			if (bishop[x][y])
				return false;
			x++;
			y--;
		}

		return true;
	}

}
