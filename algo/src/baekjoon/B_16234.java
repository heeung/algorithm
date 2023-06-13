package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16234 {
	static int[][] map;
	static boolean[][] check;
	static int L, R, N;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static int mapCnt;
	static ArrayList<Point> dots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// make map
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ret = 0;
		while (true) {
			check = new boolean[N][N];
			visited = new boolean[N][N];
			mapCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j]) {
						dots = new ArrayList<>();
						checkMap(i, j);
						if (dots.size() != 0) {
							dots.add(new Point(i, j));
							int sum = 0;
							for (Point p : dots) {
								sum += map[p.i][p.j];
							}
							int population = sum / dots.size();
							for (Point p : dots) {
								map[p.i][p.j] = population;
							}
							mapCnt++;
						}
					}
				}
			}
			if (mapCnt == 0)
				break ;
			ret++;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (check[i][j])
//						System.out.print("1");
//					else
//						System.out.print("0");
//				}
//				System.out.println();
//			}
//			System.out.println();
//
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
		System.out.println(ret);
	}

	public static void checkMap(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];

			if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && checkRange(i, j, nextI, nextJ)
					&& !visited[nextI][nextJ]) {
				check[i][j] = true;
				check[nextI][nextJ] = true;
				dots.add(new Point(nextI, nextJ));
				checkMap(nextI, nextJ);
			}
		}
	}

	public static boolean checkRange(int i, int j, int nextI, int nextJ) {
		int cal = Math.abs(map[nextI][nextJ] - map[i][j]);
		if (L <= cal && cal <= R)
			return true;
		return false;
	}
}

class Point {
	int i;
	int j;
	
	public Point(int x, int y) {
		this.i = x;
		this.j = y;
	}
}
