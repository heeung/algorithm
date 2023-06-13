package baekjoon;

import java.io.*;
import java.util.Arrays;

public class B_2448 {
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][2 * N - 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
	
		recur(0, N - 1, N);
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void recur(int i, int j, int N) {
		// 종료 조건
		if (N == 3) { // 가장 작은 삼각형 찍기
			map[i][j] = '*';
			map[i + 1][j - 1] = '*';
			map[i + 1][j + 1] = '*';
			for (int num = 0; num < 3; num++) {
				map[i + 2][j - num] = '*';
				map[i + 2][j + num] = '*';
			}
			return ;
		} else {
			// 쪼개버리기
			int devide = N / 2;
			recur(i, j, devide);
			recur(i + devide, j + devide, devide);
			recur(i + devide, j - devide, devide);
		}
	}

}
