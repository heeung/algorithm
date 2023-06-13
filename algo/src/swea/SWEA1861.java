package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1861 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int cnt, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<Point1861> list = new ArrayList<>();
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					dfs(i, j, 1);
					list.add(new Point1861(i, j, cnt, map[i][j]));
				}
			}
			Collections.sort(list);
//			for (Point1861 p : list) {
//				System.out.println(p.i + " " + p.j + " " + p.num);
//				System.out.println(p.max);
//			}
			System.out.printf("#%d %d %d\n", t + 1, list.get(0).num, list.get(0).max);
		}
	}

	public static void dfs(int i, int j, int c) {
		if (c > cnt)
			cnt = c;
		
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			Point1861 next = new Point1861(nextI, nextJ, 0);
			if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < N
					&& map[i][j] + 1 == map[next.i][next.j] && !visited[next.i][next.j]) {
				dfs(next.i, next.j, c + 1);
			}
		}
	}
}

class Point1861 implements Comparable <Point1861>{
	int i;
	int j;
	int max;
	int num;
	
	public Point1861(int i, int j, int cnt) {
		this.i = i;
		this.j = j;
		this.max = cnt;
	}
	
	public Point1861(int i, int j, int cnt, int num) {
		this.i = i;
		this.j = j;
		this.max = cnt;
		this.num = num;
	}

	@Override
	public int compareTo(Point1861 o) {
		if (o.max == this.max)
			return this.num - o.num;
		return o.max - this.max;
	}
}
