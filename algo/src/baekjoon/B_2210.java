 package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_2210 {
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[5][5];
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited[i][j] = true;
				dfs(0, 0, i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(set.size());
	}

	
	
	public static void dfs(int sum, int depth, int x, int y) {
		
		
		if (depth == 6) {
			set.add(sum);
			return ;
		}
		
		for (int d = 0; d < 4; d++) {
			int ni = x + dy[d];
			int nj = y + dx[d];
			
			if (nj < 5 && ni < 5 && nj >= 0 && ni >= 0) {
				sum = sum * 10 + map[ni][nj];
				dfs(sum, depth + 1, ni, nj);
				sum = sum / 10;
			}
		}
	}
}
