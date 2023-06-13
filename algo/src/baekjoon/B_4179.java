package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4179 {
	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static char[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int R, C, ret;
	static Queue<Point> firePoint;
	static Point me;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		firePoint = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F')
					firePoint.offer(new Point(i, j));
				if (map[i][j] == 'J')
					me = new Point(i, j);
			}
		}
		
		if (me.i == 0 || me.j == 0 || me.i == R - 1 || me.j == C - 1) {
			System.out.println("1");
			return ;
		}

		visited = new boolean[R][C];
		bfs();
		if (ans)
			System.out.println(ret + 1);
		else
			System.out.println("IMPOSSIBLE");

	}

	static void goFire() {
		int size = firePoint.size();
		while (size-- > 0) {
			Point cur = firePoint.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];

				if (ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] != 'F' && map[ni][nj] != '#') {
					map[ni][nj] = 'F';
					firePoint.offer(new Point(ni, nj));
				}
			}
		}
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(me);
		visited[me.i][me.j] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			goFire();
			while (size-- > 0) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];

					if (ni >= 0 && nj >= 0 && ni < R && nj < C && !visited[ni][nj] && map[ni][nj] != 'F'
							&& map[ni][nj] != '#') {
						if (ni == 0 || nj == 0 || ni == R - 1 || nj == C - 1) {
							ret++;
							ans = true;
							return;
						}
						visited[ni][nj] = true;
						q.offer(new Point(ni, nj));
					}
				}
			}
			ret++;
		}
	}

}

