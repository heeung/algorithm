package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SWEA1226 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int map[][];
	static boolean visited[][];
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			map = new int[16][16];
			visited = new boolean[16][16];
			String tmp = br.readLine();
			
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			ret = 0;
			bfs(1, 1);
			System.out.println("#" + (t + 1) + " " + ret);
		}
	}
	
	public static void bfs(int i, int j) {
		visited[i][j] = true;
		
		Queue<Integer[]> q = new LinkedList<>();
		Integer[] start = new Integer[] {1, 1};
		q.offer(start);
		while (!q.isEmpty()) {
			Integer[] tmp = q.poll();
			visited[tmp[0]][tmp[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nextI = tmp[0] + dx[d];
				int nextJ = tmp[1] + dy[d];
				
				if (nextI >= 1 && nextJ >= 1 && nextI < 15 && nextJ < 15
						&& map[nextI][nextJ] != 1 && !visited[nextI][nextJ]) {
					if (map[nextI][nextJ] == 3)
						ret = 1;
					Integer[] next = new Integer[] {nextI, nextJ};
					q.offer(next);
				}
			}
		}
	}

}
