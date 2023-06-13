package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10026 {
	static int[][] map1;
	static int[][] map2;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int size, cnt1, cnt2;
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		map1 = new int[size][size];
		map2 = new int[size][size];
		visited1 = new boolean[size][size];
		visited2 = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				char tmp = str.charAt(j);
				if (tmp == 'R') {
					map1[i][j] = R;
					map2[i][j] = R;
				} else if (tmp == 'G') {
					map1[i][j] = G;
					map2[i][j] = R;
				} else if (tmp == 'B') {
					map1[i][j] = B;
					map2[i][j] = B;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited1[i][j]) {
					dfs1(i, j, map1[i][j]);
					cnt1++;
				}
				if (!visited2[i][j]) {
					dfs2(i, j, map2[i][j]);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
	// 정상
	public static void dfs1(int i, int j, int color) {
		visited1[i][j] = true;
		
		for (int d = 0; d < dx.length; d++) {
			int nextI = i + dx[d];
			int nextJ = j + dy[d];
			if (nextI >= 0 && nextJ >= 0 && nextI < size && nextJ < size
					&& !visited1[nextI][nextJ] && map1[nextI][nextJ] == color) {
				dfs1(nextI, nextJ, color);
			}
		}
	}
	// 적록색약
	public static void dfs2(int i, int j, int color) {
		visited2[i][j] = true;
		
		for (int d = 0; d < dx.length; d++) {
			int nextI = i + dx[d];
			int nextJ = j + dy[d];
			if (nextI >= 0 && nextJ >= 0 && nextI < size && nextJ < size
					&& !visited2[nextI][nextJ] && map2[nextI][nextJ] == color) {
				dfs2(nextI, nextJ, color);
			}
		}
	}
}
