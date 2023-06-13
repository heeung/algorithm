package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {

	static int N, min;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		combination(0, -1, 0);
		System.out.println(min);
	}

	static void combination(int depth, int color, int sum) {
		if (depth == N) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i != color) {
				sum += map[depth][i];
				combination(depth + 1, i, sum);
				sum -= map[depth][i];
			}
		}
	}
}
