package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4485 {
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
	}
	static int N, min;
	static int[][] map, cntMap;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Point start;
	static Point end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0)
				return ;
			
			map = new int[N][N];
			cntMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(cntMap[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			start = new Point(0, 0, map[0][0]);
			end = new Point(N - 1, N - 1, map[N - 1][N - 1]);
			
			cntMap[0][0] = map[0][0];
			findMin();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(cntMap[i]));
//			}
			
			System.out.printf("Problem %d: %d\n", t, cntMap[N - 1][N - 1]);
			t++;
		}

	}
	
	public static void findMin() {
	
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.add(start);
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextI = cur.i + dy[d];
				int nextJ = cur.j + dx[d];
				
				if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N) {
					if (cntMap[nextI][nextJ] > cntMap[cur.i][cur.j] + map[nextI][nextJ]) {
						cntMap[nextI][nextJ] = cntMap[cur.i][cur.j] + map[nextI][nextJ];
						q.offer(new Point(nextI, nextJ, cntMap[nextI][nextJ]));
					}
				}
			}
		}
		
	}

}
