package baekjoon;

import java.io.*;
import java.util.*;

public class B_25969 {
	static class Point {
		int i, j, cnt, use;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
//		@Override
//		public int compareTo(Point o) {
//			return o.use - this.use;
//		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", cnt=" + cnt + ", use=" + use + "]";
		}
	}
	static int N, M, K;
	static Point start, end;
	static ArrayList<Point> newDirs;
	static Point[] np = {new Point(-1, 0), new Point(0, 1), new Point(1, 0), new Point(0, -1)};
	static int[][] map;
	static boolean[][] visited1, visited2;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited1 = new boolean[N][M];
		visited2 = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new Point(0, 0);
		end = new Point(N - 1, M - 1);
		
		// 패턴 방향 저장하기
		newDirs = new ArrayList<>();
		for (int i = -2; i <= 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = -2; j <= 2 ; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					// 2, 2 기준 상하좌우, 제자리는? 포함 안시켜도 되는,,
					if (i == 0 && j == 0) continue ;
					if (i == -1 && j == 0) continue ;
					if (i == 1 && j == 0) continue ;
					if (i == 0 && j == -1) continue ;
					if (i == 0 && j == 1) continue ;
					
					newDirs.add(new Point(i, j));
				}
			}
		}
		
//		Collections.sort(newDirs, new Comparator<Point>() {
//			@Override
//			public int compare(Point o1, Point o2) {
//				if (o1.i == o2.i) {
//					return o2.j - o1.j;
//				}
//				return o1.i - o2.i;
//			}
//		});
		
//		for (Point p : newDirs) {
//			System.out.println(p);
//		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Point> q = new LinkedList<>();
//		PriorityQueue<Point> q = new PriorityQueue<>();
		
		visited1[start.i][start.j] = true;
		visited2[start.i][start.j] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if (i == cur.i && j == cur.j) {
//						System.out.print("7 ");
//					}
//					else
//						System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(cur.cnt + " " + cur.use);
//			System.out.println("------------------------------");
			
			
			if (map[cur.i][cur.j] == 2 && !check) {
				check = true;
				visited1 = new boolean[N][M];
				visited2 = new boolean[N][M];
			}
			if (cur.i == end.i && cur.j == end.j && check && cur.use <= K) {
//				System.out.println(cur.use);
				return cur.cnt;
			}
//			if (cur.use > K) {
//				continue ;
//			}
			
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + np[d].i;
				int nj = cur.j + np[d].j;
				
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 1 && !visited1[ni][nj]) {
					visited1[ni][nj] = true;
					Point next = new Point(ni, nj);
					next.cnt = cur.cnt + 1;
					next.use = cur.use;
					q.offer(next);
				}
			}
			
			for (Point nd : newDirs) {
				int ni = cur.i + nd.i;
				int nj = cur.j + nd.j;
				
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 1 && !visited2[ni][nj] && cur.use <= K - 1) {
					Point next = new Point(ni, nj);
					visited2[ni][nj] = true;
					next.cnt = cur.cnt + 1;
					next.use = cur.use + 1;
					q.offer(next);
				}
			}
		}
		return -1;
	}

}
