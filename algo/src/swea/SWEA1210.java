package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1210 {
	static String[][]map;
	static final int dx[] = {-1, 1};
	static final int dy[] = {0, 0};
	static boolean[][] visited;
	static int ret;
	static int dir[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int T = 0; T < 10; T++) {
			String temp = br.readLine();
			map = new String[100][100];
			visited = new boolean[100][100];
			for (int i = 99; i >= 0; i--) {
				map[i] = br.readLine().split(" ");
			}
			int index = 0;
			for (int i = 0; i < 100; i++) {
				if (map[0][i].equals("2")) {
					index = i;
					break ;
				}
			}
			dfs(index, 0);
			System.out.printf("#%d %d\n", T + 1, ret);
			
		}
	}
	public static void dfs(int x, int y) {
		//종료조건
		if (y == 99) {
			ret = x;
			return ;
		}
		visited[y][x] = true;
		dir = new int[] {0, 1};
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!(nx >= 100 || nx < 0 || ny >= 100 || ny < 0) && map[ny][nx].equals("1") && !visited[ny][nx]) {
				dir = new int[] {dx[i], dy[i]};
			}
		}
		dfs(x + dir[0], y + dir[1]);
	}

}
