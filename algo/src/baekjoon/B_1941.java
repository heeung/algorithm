package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_1941 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int cntY;
	static int ret;
	static int[][] save;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		save = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited = new boolean[5][5];
				if (map[i][j] == 'S') {
					cntY = 0;
					visited[i][j] = true;
					dfs(i, j, 1);
					visited[i][j] = false;
				}
			}
		}
		System.out.println(ret);
	}
	
	public static void dfs(int i, int j, int cnt) {
		if (cntY >= 4) {
			return ;
		}
		if (cnt >= 7) {
			ret++;
			return ;
		}
		
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			
			if (nextI >= 0 && nextJ >= 0 && nextI < 5 && nextJ < 5 && !visited[nextI][nextJ]) {
//				System.out.printf("[i j][%d %d] => [nextI nextJ][%d %d] || cntY : %d\n", i, j, nextI, nextJ, cntY);
				visited[nextI][nextJ] = true;
				if (map[nextI][nextJ] == 'Y')
					cntY++;
				dfs(nextI, nextJ, cnt + 1);
				visited[nextI][nextJ] = false;
				if (map[nextI][nextJ] == 'Y')
					cntY--;
			}
		}
	}
}
