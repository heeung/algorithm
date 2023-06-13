package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_8972 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
		
	}
	static int R, C, cnt = 1;
	static Point me;
	static ArrayList<Point> robots;
	static char[][] map;
	static int[] di = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dj = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static char[] moving;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		robots = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'I') {
					me = new Point(i, j);
				}
				else if (map[i][j] == 'R') {
					robots.add(new Point(i, j));
				}
			}
		}
		
		moving = br.readLine().toCharArray();
		for (int i = 0; i < moving.length; i++) {
			move(moving[i] - '0' - 1);
			robotsMoving();
//			for (int a = 0; a < R; a++) {
//				System.out.println(Arrays.toString(map[a]));
//			}
//			System.out.println();
			cnt++;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	// 나 움직이기
	public static void move(int dir) {
		int ni = me.i + di[dir];
		int nj = me.j + dj[dir];
		if (map[ni][nj] == 'R') {
			System.out.println("kraj " + cnt);
			System.exit(0);
		} else {
			map[me.i][me.j] = '.';
			map[ni][nj] = 'I';
			me.i = ni;
			me.j = nj;
		}
	}
	// 로봇들 움직이기
	public static void robotsMoving() {
		
		HashSet<Point> sets = new HashSet<>();
		Queue<Point> bombed = new LinkedList<>();
		Queue<Point> notBombed = new LinkedList<>();
		
		
		for (Point cur : robots) {
			
			int nextI = 0;
			int nextJ = 0;
			
			int min = Integer.MAX_VALUE;
			for (int d = 0; d < 9; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
					if (map[ni][nj] == 'I') {
						System.out.println("kraj " + cnt);
						System.exit(0);
					}
					int dis = Math.abs(ni - me.i) + Math.abs(nj - me.j);
					if (dis < min) {
						min = Math.min(min, dis);
						nextI = ni;
						nextJ = nj;
					}
				}
			}
			map[cur.i][cur.j] = '.';
//			map[nextI][nextJ] = 'R';
			cur.i = nextI;
			cur.j = nextJ;
			
			if (sets.contains(cur)) {
				bombed.offer(cur);
			} else {
				sets.add(cur);
				notBombed.offer(cur);
			}
		}
//		for (Point cur : notBombed) {
//			System.out.println(cur);
//		}

		robots.clear();
		
		while (!notBombed.isEmpty()) {
			Point cur = notBombed.poll();
			map[cur.i][cur.j] = 'R'; 
			robots.add(cur);
		}
		while (!bombed.isEmpty()) {
			Point cur = bombed.poll();
			map[cur.i][cur.j] = '.';
			robots.remove(cur);
		}
	}
}
