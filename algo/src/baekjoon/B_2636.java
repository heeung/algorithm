package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2636 {
	static int sizeI, sizeJ;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visited;
	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		sizeI = Integer.parseInt(st.nextToken());
		sizeJ = Integer.parseInt(st.nextToken());
		
		map = new int[sizeI][sizeJ];
		visited = new boolean[sizeI][sizeJ];
		// 맵 생성
		for (int i = 0; i < sizeI; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < sizeJ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map2 = new int[sizeI][sizeJ];
		int flag = 1;
		int time = 0;
		while (flag == 1) {
			time++;
			flag = 0;
			int[][] tmpMap = new int[sizeI][sizeJ];
			for (int i = 0; i < sizeI; i++) {
				tmpMap[i] = map[i].clone();
			}
		}
		for (int i = 0; i < sizeI; i++) {
			for (int j = 0; j < sizeJ; j++) {
				if (!visited[i][j])
					dfs(i, j);
			}
		}
		
		for (int i = 0; i < sizeI; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
	
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		for(int d = 0; d < 4; d++) {
			int nextI = i + dx[d];
			int nextJ = i + dx[d];
			if (nextI > 0 && nextJ > 0 && nextI < sizeI && nextJ < sizeJ
					&& !visited[nextI][nextJ]) {
				if (map[nextI][nextJ] == 1)
					map[nextI][nextJ] = 0;
				dfs(nextI, nextJ);
			}
		}
	}
}
