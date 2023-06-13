package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17182 {
	
	static int N, K;
	static ArrayList<Integer>[] graph;
	static int[][] map;
	static boolean[] visited;
	static int check, cnt, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pickBest();
		visited[K] = true;
		min = 211111111;
		combination(new int[N - 1], 0);
		System.out.println(min);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
	}
	
	public static void combination(int[] comb, int depth) {
		if (depth == N - 1) {
//			System.out.println(Arrays.toString(comb));
			cnt = 0;
			count(comb);
			min = Math.min(cnt, min);
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = i;
				combination(comb, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void count(int[] comb) {
		int from  = 0;
		int to = 0;
		for (int i = 0; i < comb.length; i++) {
			if (i == 0) {
				from = K;
				to = comb[i];
			} else {
				from = comb[i - 1];
				to = comb[i];
			}
//			System.out.printf("from : %d, to : %d\n", from, to);
			cnt += map[from][to];
		}
	}

	public static void pickBest() {
		for(int mid = 0; mid < N; mid++)
            for(int from = 0; from < N; from++)
                for(int to = 0; to < N; to++)
                	map[from][to] = Math.min(map[from][mid] + map[mid][to], map[from][to]);
	}
}
