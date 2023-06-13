package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
	static class Point {
		int i;
		int j;
		int num;
		public Point(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}
	static int N, M;
	static Point manhole;
	static int time;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (R == i && C == j)
						manhole = new Point(R, C, map[i][j]);
				}
			}
			visited = new boolean[N][M];
			bfs();
			int ret = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
//						System.out.print("1 ");
						ret++;
					}
//					} else {
//						System.out.print("0 ");
//					}
				}
//				System.out.println();
			}
			System.out.printf("#%d %d\n", t + 1, ret);
		}
	}
	
	public static void bfs() {
		int cnt = 1;
		
		visited[manhole.i][manhole.j] = true;
		Queue<Point> q = new LinkedList<>();
		
		q.offer(manhole);
		while (!q.isEmpty()) {
			if (cnt == time)
				break ;
			cnt++;
			ArrayList<Point> arr = new ArrayList<>();
			while (!q.isEmpty()) {
				arr.add(q.poll());
			}
			
			for (Point cur : arr) {
				
				if (cur.num == 1) {
					for (int d = 0; d < 4; d++) {
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 2) {
					for (int d = 0; d < 4; d++) {
						if (d == 1 || d == 3)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 3) {
					for (int d = 0; d < 4; d++) {
						if (d == 0 || d == 2)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 4) {
					for (int d = 0; d < 4; d++) {
						if (d == 2 || d == 3)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 5) {
					for (int d = 0; d < 4; d++) {
						if (d == 0 || d == 3)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 6) {
					for (int d = 0; d < 4; d++) {
						if (d == 0 || d == 1)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				} else if (cur.num == 7) {
					for (int d = 0; d < 4; d++) {
						if (d == 1 || d == 2)
							continue ;
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (check(nextI, nextJ, d)) {
							visited[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ, map[nextI][nextJ]));
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int i, int j, int d) {
		if (i >= 0 && j >= 0 && i < N && j < M && map[i][j] != 0 && !visited[i][j]) {
			if (d == 0) {
				if (map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 7) {
					return false;
				}
			} else if (d == 1) {
				if (map[i][j] == 2 || map[i][j] == 4 || map[i][j] == 5) {
					return false;
				}
			} else if (d == 2) {
				if (map[i][j] == 3 || map[i][j] == 5 || map[i][j] == 6) {
					return false;
				}
			} else if (d == 3) {
				if (map[i][j] == 2 || map[i][j] == 6 || map[i][j] == 7) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
