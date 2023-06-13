package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11404 {

	static int[][] graph, res;
	static int N, M;
	static boolean[] visited;
	static int cnt, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		res = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int num = Integer.parseInt(st.nextToken());
			if (graph[from][to] != 0)
				graph[from][to] = Math.min(graph[from][to], num);
			else
				graph[from][to] = num;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 0)
					graph[i][j] = 300000000;
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
//
//		System.out.println();
		pickBest();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					graph[i][j] = 0;
				}
				if (graph[i][j] == 300000000) {
					graph[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

//		find();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(res[i]));
//		}
//		System.out.println();

	}

	public static void pickBest() {
		for (int mid = 0; mid < N; mid++)
			for (int from = 0; from < N; from++)
				for (int to = 0; to < N; to++)
					graph[from][to] = Math.min(graph[from][mid] + graph[mid][to], graph[from][to]);
	}
//
//	public static void find() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (i != j && graph[i][j] == 0) {
//					visited = new boolean[N];
//					visited[i] = true;
//					min = 300000;
//					cnt = 0;
//					System.out.println(" i:" + i + " j:" + j);
//					getCost(i, j);
//					System.out.println("cnt : " + cnt);
//					System.out.println();
//					min = Math.min(min, cnt);
//					res[i][j] = min;
//				}
//				if (graph[i][j] != 0) {
//					res[i][j] = graph[i][j];
//				}
//			}
//		}
//	}
//
//	public static void getCost(int from, int to) {
//
//		for (int i = 0; i < N; i++) {
//			if (!visited[i] && graph[from][i] != 0) {
//				if (to == i) {
//					cnt += graph[from][i];
//					System.out.println("탈출 from : " + from + " i : " + i + ": " + graph[from][i] + " cnt : " + cnt);
//					return;
//				}
//				visited[i] = true;
//				cnt += graph[from][i];
//				System.out.println("from : " + from + " i : " + i + ": " + graph[from][i]);
//				getCost(i, to);
//				visited[i] = false;
////				cnt -= graph[from][i];
//			}
//		}
//	}
}
