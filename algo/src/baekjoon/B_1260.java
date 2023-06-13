package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260 {
	
	static ArrayList<Integer>[] graph;
	static int node, edge;
	static int start;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		for (int i = 1; i <= node; i++) {
			Collections.sort(graph[i]);
		}
		
		visited = new boolean[node + 1];
		dfs(start);
		System.out.println();
		visited = new boolean[node + 1];
		bfs(start);
		System.out.println();
		
	}
	
	public static void dfs(int head) {
		visited[head] = true;
		System.out.print(head + " ");
		
		for (Integer n : graph[head]) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}
	
	public static void bfs(int head) {
		visited[head] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(head);
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (Integer n : graph[cur]) {
				if (!visited[n]) {
					visited[n] = true;
					q.offer(n);
				}
			}
		}
	}

}
