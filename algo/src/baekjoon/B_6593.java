package baekjoon;

import java.io.*;
import java.util.*;

public class B_6593 {
	static class Point {
		int h, i, j;

		public Point(int h, int i, int j) {
			this.h = h;
			this.i = i;
			this.j = j;
		}
	}
	static int L, R, C, cnt;
	static char[][][] map;
	static boolean visited[][][];
	static int[] di = {-1, 0, 1, 0, 0, 0};
	static int[] dj = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static Point start, end;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			isPossible = false;
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if (L == 0 || R == 0 || C == 0) {
				break ;
			}
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			for (int h = 0; h < L; h++) {
				for (int i = 0; i < R; i++) {
					String str = br.readLine();
					for (int j = 0; j < C; j++) {
						map[h][i][j] = str.charAt(j);
						if (map[h][i][j] == 'S') {
							start = new Point(h, i, j);
						} else if (map[h][i][j] == 'E') {
							end = new Point (h, i, j);
						}
					}
				}
				br.readLine();
			}
			
			cnt = 0;
			bfs();
			
			if (!isPossible || cnt == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.printf("Escaped in %d minute(s).\n", cnt);
			}
		}
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		
		visited[start.h][start.i][start.j] = true;
		while (!q.isEmpty()) {
			
			ArrayList<Point> arr = new ArrayList<>();
			while (!q.isEmpty()) {
				arr.add(q.poll());
			}
			
			for (Point cur : arr) {
//				System.out.println(map[cur.h][cur.i][cur.j]);
				if (map[cur.h][cur.i][cur.j] == 'E') {
					isPossible = true;
					return ;
				}
				for (int d = 0; d < 6; d++) {
					int nh = cur.h + dh[d];
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					if (nh < L && ni < R && nj < C
							&& nh >= 0 && ni >= 0 && nj >= 0
							&& !visited[nh][ni][nj] && (map[nh][ni][nj] == '.' || map[nh][ni][nj] == 'E')) {
						visited[nh][ni][nj] = true;
						q.offer(new Point(nh, ni, nj));
					}
				}
			}
			cnt++;
		}
	}

}
