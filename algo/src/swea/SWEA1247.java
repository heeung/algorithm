package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1247 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Point[] info;
	static int N, min;
	static boolean[] visited;
	static Point company, home;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			info = new Point[N];
			visited = new boolean[N];
			
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N; i++) {
				info[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = 30000000;
			combination(new int[N], 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	
	public static int getDistance(int from, int to) {
		int x = Math.abs(info[from].x - info[to].x);
		int y = Math.abs(info[from].y - info[to].y);
		return x + y;
	}
	
	public static void solve(int[] comb) {
		int sum = 0;
		sum += Math.abs(company.x - info[comb[0]].x) + Math.abs(company.y - info[comb[0]].y);
		sum += Math.abs(home.x - info[comb[N - 1]].x) + Math.abs(home.y - info[comb[N - 1]].y);
		
		for (int i = 0; i < N - 1; i++) {
			sum += getDistance(comb[i], comb[i + 1]);
		}
		if (sum < min) {
			min = Math.min(sum, min);
		}
	}
	
	public static void combination(int[] comb, int depth) {
		
		if (depth == N) {
			solve(comb);
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				comb[depth] = i;
				visited[i] = true;
				combination(comb, depth + 1);
				visited[i] = false;
			}
		}
	}
}
