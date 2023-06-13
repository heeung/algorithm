package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_14502 {
	
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] check;
	static Point[] dots;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<Point> virus;
	static ArrayList<Integer> list;
	static int zeroCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 맵생성
		map = new int[N][M];
		dots = new Point[N * M];
		check = new boolean[N * M];
		virus = new ArrayList<>();
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dots[i * M + j] = new Point(i, j);
				if (map[i][j] == 0)
					zeroCnt++;
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}
//		visited = new boolean[N][M];
		cnt = 0;
		combination(new Point[3], 0, 0);
		Collections.sort(list, Collections.reverseOrder());
//		for(Integer n : list)
//			System.out.print(n + " ");
		System.out.println(list.get(0) - 3);
		
//		for (Point p : dots) {
//			System.out.println(p.i + " " + p.j);
//		}

	}
	
	public static void setWall(Point[] comb) {
		for (int i = 0; i < 3; i++) {
			map[comb[i].i][comb[i].j] = 1;
		}
		visited = new boolean[N][M];
		for (Point p : virus) {
			dfs(p.i, p.j);
//			System.out.printf("wall : [%d, %d], [%d, %d], [%d, %d]\n", comb[0].i, comb[0].j,  comb[1].i, comb[1].j, comb[2].i, comb[2].j);
//			System.out.printf("[%d %d] : cnt = %d\n", p.i, p.j, cnt);
		}
		for (int i = 0; i < 3; i++) {
			map[comb[i].i][comb[i].j] = 0;
		}
	}
	
	public static void dfs(int i, int j) {
		
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			Point next = new Point(nextI, nextJ);
			if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < M
					&& map[nextI][nextJ] == 0 && !visited[nextI][nextJ]) {
				visited[nextI][nextJ] = true;
				cnt++;
				dfs(nextI, nextJ);
			}
		}
	}
	
	public static void combination(Point[] comb, int depth, int idx) {
		
		if (depth == 3) {
//			print(comb);
			cnt = 0;
			setWall(comb);
			list.add(zeroCnt - cnt);
			return ;
		}
		if (idx == N * M)
			return ;
		
		for (int i = idx; i < N * M; i++) {
			if (map[dots[i].i][dots[i].j] == 0 && !check[i]) {
				check[i] = true;
				comb[depth] = dots[i];
				combination(comb, depth + 1, i + 1);
				check[i] = false;
			}
		}
	}
	
//	public static void print(Point[] comb) {
//		for (int i = 0; i < 3; i++) {
//			System.out.print("[" + comb[i].i + ", " + comb[i].j + "] ");
//		}
//		System.out.println();
//	}

}
