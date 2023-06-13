package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, cnt;
	static Point now, dest;
	static boolean[][] visited;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			cnt = 0;
			visited = new boolean[N][N];
			bfs();
			System.out.println(cnt);
		}
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(now);
		while (!q.isEmpty()) {
			ArrayList<Point> arr = new ArrayList<>();
			while (!q.isEmpty())
				arr.add(q.poll());
			
			for (Point cur : arr) {
				if (cur.i == dest.i && cur.j == dest.j)
					return ;
				for (int d = 0; d < 8; d++) {
					Point n = new Point(cur.i + dy[d], cur.j + dx[d]);
					if (n.i >= 0 && n.j >= 0 && n.i < N && n.j < N && !visited[n.i][n.j]) {
						visited[n.i][n.j]= true;
						q.offer(n);
					}
				}
			}
			cnt++;
				
		}
	}

}
