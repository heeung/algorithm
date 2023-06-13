package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_23288 {

	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[][] map;
	static boolean[][] visited;
	static int N, M, K;
	static int dir;
	static Dice dice;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int point;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dir = 1;
		dice = new Dice(1, 6, 2, 3, 5, 4);
		go(0, 0);
		System.out.println(point);
	}
	
	public static void go(int i, int j) {
		for (int t = 0; t < K; t++) {
			int nextI = i + dy[dir];
			int nextJ = j + dx[dir];
			if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M) {
				dir = (dir + 2) % 4;
				nextI = i + dy[dir];
				nextJ = j + dx[dir];
			}
			dice = dice.roll(dir);
			visited = new boolean[N][M];
			bfs(nextI, nextJ);
			i = nextI;
			j = nextJ;
			if (dice.bottom > map[i][j]) {
				dir += 1;
				if (dir > 3)
					dir = dir % 4;
			} else if (dice.bottom < map[i][j]) {
				dir -= 1;
				if (dir < 0)
					dir = dir + 4;
			}
		}
	}

	public static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		visited[i][j] = true;
		int num = map[i][j];
		point += num;
		q.offer(new Point(i, j));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nextI = cur.i + dy[d];
				int nextJ = cur.j + dx[d];
				if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < M && !visited[nextI][nextJ] 
						&& map[nextI][nextJ] == num) {
					visited[nextI][nextJ] = true;
					point += num;
					q.offer(new Point(nextI, nextJ));
				}
			}
		}
	}
}

class Dice {
	int top;
	int bottom;
	int n;
	int e;
	int s;
	int w;
	public Dice(int top, int bottom, int n, int e, int s, int w) {
		this.top = top;
		this.bottom = bottom;
		this.n = n;
		this.e = e;
		this.s = s;
		this.w = w;
	}
	public Dice roll(int dir) {
		if (dir == 0) {
			return new Dice(this.s, this.n, this.top, this.e, this.bottom, this.w);			
		} else if (dir == 1) {
			return new Dice(this.w, this.e, this.n, this.top, this.s, this.bottom);			
		} else if (dir == 2) {
			return new Dice(this.n, this.s, this.bottom, this.e, this.top, this.w);			
		} else {
			return new Dice(this.e, this.w, this.n, this.bottom, this.s, this.top);			
		}
	}
	
}
