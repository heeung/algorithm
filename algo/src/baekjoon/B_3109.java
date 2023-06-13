package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_3109 {
	static int R, C, cnt;
	static char[][] map;
	static boolean[] visited;
	static int[] di = {-1, 0, 1};
	static int[] dj = {1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			solve(i, 0, i);
		}
		System.out.println(cnt);
	}
	
	static void solve(int si, int sj, int line) {
		if (sj == C - 1) {
			if (!visited[line]) {
				cnt++;
				visited[line] = true;
			}
			return ;
		}
		
		map[si][sj] = 'x';
		for (int d = 0; d < 3; d++) {
			int ni = si + di[d];
			int nj = sj + dj[d];
			if (ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] != 'x' && !visited[line]) {
				solve(ni, nj, line);
			}
		}
		
	}
	
//	static void bfs(int si, int sj) {
//		map[si][sj] = 'x';
//		
//		Queue<Integer> iq = new LinkedList<>();
//		Queue<Integer> jq = new LinkedList<>();
//		
//		iq.offer(si);
//		jq.offer(sj);
//		while (!iq.isEmpty()) {
//			int ci = iq.poll();
//			int cj = jq.poll();
//			for (int d = 0; d < 3; d++) {
//				int ni = ci + di[d];
//				int nj = cj + dj[d];
//				if (ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] != 'x') {
//					map[ni][nj] = 'x';
//					iq.offer(ni);
//					jq.offer(nj);
//				}
//			}
//		}
//	}
}
