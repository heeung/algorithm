package baekjoon;

import java.io.*;
import java.util.*;

public class B_1987 {
	static char[][] map;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int R, C, max;
	static boolean[] alpha;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		alpha = new boolean[26];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited[0][0] = true;
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
	}

	static void dfs(int i, int j, int cnt) {
		max = Math.max(cnt, max);
		
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < R && nj < C && ni >= 0 && nj >= 0 && !visited[ni][nj]
					&& !alpha[map[ni][nj] - 'A']) {
				visited[ni][nj] = true;
				alpha[map[ni][nj] - 'A'] = true;
				dfs(ni, nj, cnt + 1);
				alpha[map[ni][nj] - 'A'] = false;
				visited[ni][nj] = false;
			}
		}
	}
}
