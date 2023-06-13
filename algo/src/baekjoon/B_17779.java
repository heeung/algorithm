package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17779 {
	static int N;
	static int[][] map;
	static int[][] divideMap;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ret;
	static int cnt5;

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
		ret = Integer.MAX_VALUE;
		combination();
		System.out.println(ret);
	}

	// 경우의 수 모두 탐색
	public static void combination() {
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				for (int d1 = 1; d1 <= j; d1++) {
					for (int d2 = 1; d2 <= N - j - 1 && d2 + d1 + i < N; d2++) {
						if (i + d1 + d2 >= N)
							break;
						divideMap = new int[N][N];
//						System.out.printf("d1 : %d, d2 : %d\n", d1, d2);
//						System.out.printf("i : %d, j : %d\n", i, j);
						divide(i, j, d1, d2);
					}
				}
			}
		}
	}

	// 구역 나누기
	public static void divide(int i, int j, int d1, int d2) {
		cnt5 = 0;
		for (int n = 0; n <= d1; n++) {
			divideMap[i + n][j - n] = 5;
			divideMap[i + d2 + n][j + d2 - n] = 5;
		}
		for (int n = 1; n < d2; n++) {
			divideMap[i + n][j + n] = 5;
			divideMap[i + d1 + n][j - d1 + n] = 5;
		}
		ret = Math.min(ret, getPoint(i, j, d1, d2));
		for (int a = 0; a < N; a++) {
			System.out.println(Arrays.toString(divideMap[a]));
		}
	}

	public static int getPoint(int x, int y, int d1, int d2) {
		int cntMin = Integer.MAX_VALUE;
		int cntMax = Integer.MIN_VALUE;
		// 1번 구역
		int cnt = 0;
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (divideMap[i][j] == 5)
					break;
				cnt += map[i][j];
			}
		}
		cntMin = Math.min(cntMin, cnt);
		cntMax = Math.max(cntMax, cnt);
		// 2번구역
		cnt = 0;
		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j > y; j--) {
				if (divideMap[i][j] == 5)
					break;
				cnt += map[i][j];
			}
		}
		cntMin = Math.min(cntMin, cnt);
		cntMax = Math.max(cntMax, cnt);
		// 3번구역
		cnt = 0;
		for (int i = N - 1; i >= x + d1; i--) {
			for (int j = 0; j < y; j++) {
				if (divideMap[i][j] == 5)
					break;
				cnt += map[i][j];
			}
		}
		cntMin = Math.min(cntMin, cnt);
		cntMax = Math.max(cntMax, cnt);
		// 4번구역
		cnt = 0;
		for (int i = N - 1; i > x + d2; i--) {
			for (int j = N - 1; j >= y - (d1 - d2); j--) {
				if (divideMap[i][j] == 5)
					break;
				cnt += map[i][j];
			}
		}
		cntMin = Math.min(cntMin, cnt);
		cntMax = Math.max(cntMax, cnt);
		
		// 5번구역
		System.out.println(cntMax - cntMin);
		System.out.printf("Max : %d, Min : %d\n", cntMax, cntMin);
		return cntMax - cntMin;
	}

}