package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18234 {
	static ArrayList<Integer>[] graph;
	static int node, edge;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		graph = new ArrayList[node + 1];
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= node; i++) {
			visited = new boolean[node + 1];
			cnt = 0;
			bfs(i);
			for (int j = 1; j <= node; j++) {
				if (!visited[j]) {
					System.out.println("Big World!");
					return ;
				}
			}
		}
		System.out.println("Small World!");
	}

	public static void bfs(int head) {
		visited[head] = true;

		Queue<Integer> q = new LinkedList<>();
		q.offer(head);

		while (!q.isEmpty()) {
			if (cnt > 6) {
				System.out.println("Big World!");
				System.exit(0);
			}
			ArrayList<Integer> arr = new ArrayList<>();
			while (!q.isEmpty()) {
				arr.add(q.poll());
			}

			for (Integer n : arr) {
				for (int i = 0; i < graph[n].size(); i++) {
					if (!visited[graph[n].get(i)]) {
						q.offer(graph[n].get(i));
						visited[graph[n].get(i)] = true;
					}
				}
			}
			cnt++;
		}

	}

}
