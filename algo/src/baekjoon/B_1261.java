package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1261 {
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int cost;
		public Point(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", cost=" + cost + "]";
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 맵 정보 입력받기
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		dijk();
	}
	
	static void dijk() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			if (cur.i == N - 1 && cur.j == M - 1) {
				System.out.println(cur.cost);
				return ;
			}
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && !visited[ni][nj]) {
					visited[ni][nj] = true;
					pq.offer(new Point(ni, nj, map[ni][nj] + cur.cost));
				}
			}
		}
	}
}
