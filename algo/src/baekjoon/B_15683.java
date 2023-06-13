package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_15683 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class CCTV {
		int i;
		int j;
		int cctvNum;
		ArrayList<int[]> dirList;
		
		public CCTV(int i, int j, int cctvNum) {
			this.i = i;
			this.j = j;
			this.cctvNum = cctvNum;
			this.dirList = getDir(cctvNum);
		}
		public ArrayList<int[]> getDir(int cctvNum) {
			ArrayList<int[]> list = new ArrayList<>();
			if (cctvNum == 1) {
				list.add(new int[] {0});
				list.add(new int[] {1});
				list.add(new int[] {2});
				list.add(new int[] {3});
			} else if (cctvNum == 2) {
				list.add(new int[] {0, 2});
				list.add(new int[] {1, 3});
			} else if (cctvNum == 3) {
				list.add(new int[] {0, 1});
				list.add(new int[] {1, 2});
				list.add(new int[] {2, 3});
				list.add(new int[] {3, 0});
			} else if (cctvNum == 4) {
				list.add(new int[] {0, 1, 2});
				list.add(new int[] {1, 2, 3});
				list.add(new int[] {2, 3, 0});
				list.add(new int[] {3, 0, 1});
			} else if (cctvNum == 5) {
				list.add(new int[] {0, 1, 2, 3});
			}
			return list;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<CCTV> cctvs;
	static int rangeCnt, zeroCnt;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				} else if (map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		visited = new boolean[N][M];
		list = new ArrayList<>();
		fillMap(0);
		Collections.sort(list, Collections.reverseOrder());
//		for (Integer n : list) {
//			System.out.print(n + " ");
//		}
		
		System.out.println(zeroCnt - list.get(0));
	}
	
	public static void fillMap(int idx) {
		if (idx == cctvs.size()) {
			list.add(rangeCnt);
			return ;
		}
		
		CCTV cctv = cctvs.get(idx);
		// cctv를 90도 돌려가면서 볼수 있는 경우의 수 모두 탐색
		for (int[] d : cctv.dirList) {
			// cctv종류에 맞게 탐색되는 부분 모두 색칠
			ArrayList<Point> dots = new ArrayList<>();
			for (int n : d) {
				fillRange(cctv.i, cctv.j, n, dots);
			}
			fillMap(idx + 1);
			resetRange(dots);
		}
	}
	
	public static void fillRange(int i, int j, int dir, ArrayList<Point> dots) {
		while (true) {
			int nextI = i + dy[dir];
			int nextJ = j + dx[dir];
//			System.out.println("nextI:" + nextI + "nextJ:" + nextJ);
			if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M
					|| map[nextI][nextJ] == 6) {
				break ;
			}
			if (!visited[nextI][nextJ] && map[nextI][nextJ] == 0) {
				visited[nextI][nextJ] = true;
				dots.add(new Point(nextI, nextJ));
				rangeCnt++;
			}
			i = nextI;
			j = nextJ;
		}
	}
	
	public static void resetRange(ArrayList<Point> dots) {
		for (Point dot : dots) {
			visited[dot.i][dot.j] = false;
			rangeCnt--;
		}
	}
}
