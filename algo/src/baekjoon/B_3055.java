package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B_3055 {
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int cnt;
	static Point d, s;
	static boolean flag;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'D')
					d = new Point(i, j);
				if (map[i][j] == 'S')
					s = new Point(i, j);
			}
		}
		bfs(s);
		if (flag)
			System.out.println(cnt);
		else
			System.out.println("KAKTUS");
	}

	public static void bfs(Point s) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(s);
		visited[s.i][s.j] = true;
		while (!q.isEmpty()) {
			ArrayList<Point> arr = new ArrayList<>();
			while (!q.isEmpty())
				arr.add(q.poll());
			fillWater();
			for (Point cur : arr) {
				if (cur.i == d.i && cur.j == d.j) {
					flag = true;
					return ;
				}
				for (int d = 0; d < 4; d++) {
					int nextI = cur.i + dy[d];
					int nextJ = cur.j + dx[d];
					if (nextI >= 0 && nextJ >= 0 &&  nextI < N && nextJ < M && !visited[nextI][nextJ]
							&& map[nextI][nextJ] != 'X' && map[nextI][nextJ] != '*') {
						visited[nextI][nextJ] = true;
						q.offer(new Point(nextI, nextJ));
					}
				}
			}
			cnt++;
		}
	}
	
	public static void fillWater() {
		boolean[][] check = new boolean[N][M];
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*' && !check[i][j]) {
//					System.out.printf("i : %d, j : %d\n", i, j);
					for (int d = 0; d < 4; d++) {
						int nextI = i + dy[d];
						int nextJ = j + dx[d];
						if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < M && map[nextI][nextJ] != 'D'
								&& map[nextI][nextJ] != '*' && map[nextI][nextJ] != 'X') {
							check[nextI][nextJ] = true;
							map[nextI][nextJ] = '*';
						}
					}
				}
			}
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}
