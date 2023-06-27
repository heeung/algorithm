package softeer;

import java.io.*;
import java.util.*;

public class Softeer_동계테스트 {
	static class Point{
		int i, j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, M, all, ret;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					all++;
				}
			}
		}
		
		while (all > 0) {
			visited = new boolean[N][M];
			bfs(0, 0);
			map = melting();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("------------------------");
		}
//		bfs(0, 0);
//		map = melting();
		
		System.out.println(ret);
	}

	// 얼음 안에 공기 차있는지 판단
	// 겉 == 2
	// 안쪽 공기 == 0
	static void bfs(int i, int j) { // 얼음 안에 공기 차있는지 판단
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(i, j));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			map[cur.i][cur.j] = 2;
			
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && !visited[ni][nj] && map[ni][nj] != 1) {
					q.offer(new Point(ni, nj));
					visited[ni][nj] = true;
				}
			}
		}
	}
	
	static int[][] melting() {
		ret++;
		
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			tmp[i] = map[i].clone();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					continue ;
				// 상하좌우 확인
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					if (map[i + di[d]][j + dj[d]] == 2) {
						cnt++;
					}
				}
				if (cnt >= 2) {
					tmp[i][j] = 2;
					all--;
				}
			}
		}
		return tmp;
	}
}
