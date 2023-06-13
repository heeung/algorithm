package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_화학물질2 {
	static class Procession implements Comparable<Procession> {
		int i;
		int j;
		int sizeI;
		int sizeJ;
		int size;

		@Override
		public String toString() {
			return " " + sizeI + " " + sizeJ;
		}

		public Procession(int i, int j, int sizeI, int sizeJ) {
			this.i = i;
			this.j = j;
			this.sizeI = sizeI;
			this.sizeJ = sizeJ;
			this.size = sizeI * sizeJ;
		}

		@Override
		public int compareTo(Procession o) {
			if (this.size == o.size) {
				return this.sizeI - o.sizeI;
			}
			return this.size - o.size;
		}
	}

	static int N, cnt, maxNode, max, ans;
	static int[][] map;
	static PriorityQueue<Procession> pros;
	static boolean[][] visited;
	static ArrayList<Integer>[] graph;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N + 1][N + 1];

			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			pros = new PriorityQueue<>();
			visited = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0 && !visited[i][j])
						getPros(i, j);
				}
			}
			
			graph = new ArrayList[N + 1];
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			
			while (!pros.isEmpty()) {
				Procession cur = pros.poll();
				graph[cur.sizeI].add(cur.sizeJ);
			}
			
			max = 0;
			maxNode = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				check = new boolean[N + 1];
				check[i] = true;
				dfs(i);
				if (cnt > max) {
					max = cnt;
					maxNode = i;
				}
			}
			
			
			
			check = new boolean[N + 1];
			ans = 0;
			sum(graph[maxNode].get(0));
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void sum(int head) {
		check[head] = true;
		for (Integer n : graph[head]) {
			ans += maxNode * (head * n);
			if (!check[n]) {
				check[n] = true;
				sum(n);
				check[n] = false;
			}
		}
	}
	
	public static void dfs(int head) {
		check[head] = true;
		for (Integer n : graph[head]) {
			if (!check[n]) {
				check[n] = true;
				cnt++;
				dfs(n);
				check[n] = false;
			}
		}
	}

	public static void getPros(int x, int y) {

		int i = x;
		while (i <= N && map[i][y] != 0) {
			for (int jj = y; jj <= N; jj++) {
				if (map[i][jj] == 0)
					break;
				visited[i][jj] = true;
			}
			i++;
		}

		int j = y;
		while (j <= N && map[x][j] != 0) {
			j++;
		}

		pros.offer(new Procession(x, y, (i - x), (j - y)));
	}
}