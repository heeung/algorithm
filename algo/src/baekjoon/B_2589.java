package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2589 {
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
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int N, M, max, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					cnt = 0;
					visited = new boolean[N][M];
					bfs(new Point(i, j));
					max = Math.max(cnt, max);
				}
			}
		}
		System.out.println(max - 1);

	}
	
	public static void bfs(Point head) {
		visited[head.i][head.j]= true;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(head);
		
		while (!q.isEmpty()) {
			
			ArrayList<Point> arr = new ArrayList<>();
			while (!q.isEmpty())
				arr.add(q.poll());
			
			for (Point cur : arr) {
				for (int d = 0; d < 4; d++) {
					Point next = new Point(cur.i + dy[d], cur.j + dx[d]);
					if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < M && !visited[next.i][next.j]
							&& map[next.i][next.j] == 'L') {
						visited[next.i][next.j] = true;
						q.offer(next);
					}
				}
			}
			cnt++;
		}
	}

}
