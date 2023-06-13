package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1949 {
	static int N, dig;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Point1949> highest;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int maxCnt, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dig = Integer.parseInt(st.nextToken());

			// 맵 생성
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			highest = new ArrayList<>();
			pickHighest();
			ArrayList<Integer> cnts = new ArrayList<>();
			while (dig >= 0) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] -= dig;
//						System.out.println("dig poing : " + i + " " + j);
						visited = new boolean[N][N];
						maxCnt = 0;
						for (Point1949 p : highest) {
							cnt = 0;
//							bfs(p.i, p.j);
//							System.out.printf("[%d, %d]\n", p.i, p.j);
//							System.out.println();
							visited[p.i][p.j] = true; 
							dfs(p.i, p.j, 1);
							if (maxCnt < cnt) {
								maxCnt = cnt;
							}
							visited[p.i][p.j] = false;
//							System.out.printf("[%d, %d] : cnt = %d\n", p.i, p.j, cnt);
//							System.out.println();
						}
						cnts.add(maxCnt);
						map[i][j] += dig;
					}
				}
				dig--;
			}
			
//			for (Integer n : cnts) {
//				System.out.println(n);
//			}
			
			Collections.sort(cnts);
			System.out.printf("#%d %d\n", t + 1, cnts.get(cnts.size() - 1));
		}
	}

	public static void pickHighest() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < map[i][j])
					max = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max == map[i][j])
					highest.add(new Point1949(i, j));
			}
		}
	}
	public static void dfs(int i, int j, int c) {
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			Point1949 next = new Point1949(nextI, nextJ);
			if (cnt < c)
				cnt = c;
			
			if (next.i >= 0 && next.j >= 0 && next.i < N && next.j < N && map[next.i][next.j] < map[i][j]
					&& !visited[next.i][next.j]) {
				
				visited[next.i][next.j] = true;
				dfs(next.i, next.j, c + 1);
				visited[next.i][next.j] = false;
			}
		}
	}

}

class Point1949 {
	int i;
	int j;

	public Point1949(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
