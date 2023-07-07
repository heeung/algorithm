package baekjoon;

import java.io.*;
import java.util.*;

public class B_21940 {
	static class Node {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static int node, edge, f;
	static int[][] graph;
	static int[] friends, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		graph = new int[node + 1][node + 1];
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				graph[i][j] = Integer.MAX_VALUE;
			}
			graph[i][i] = 0;
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (graph[from][to] > cost)
				graph[from][to] = cost;
		}

		f = Integer.parseInt(br.readLine());
		friends = new int[f];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < f; i++) {
			friends[i] = Integer.parseInt(st.nextToken());
		}
		
		floyd();

		max = new int[node + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= node; i++) {
			for (int j = 0; j < f; j++) {
				max[i] = Math.max(max[i], graph[friends[j]][i] + graph[i][friends[j]]);
			}
			min = Math.min(min, max[i]);
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= node; i++) {
			if (min >= max[i])
				result.add(i);
		}
		Collections.sort(result);

		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public static void floyd() {
		for (int mid = 1; mid <= node; mid++)
			for (int from = 1; from <= node; from++)
				for (int to = 1; to <= node; to++)
					if(graph[from][to] > graph[from][mid] + graph[mid][to])
						graph[from][to] = graph[from][mid] + graph[mid][to];
	}
}
