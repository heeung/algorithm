package baekjoon;

import java.io.*;
import java.util.*;

public class B_13023 {
	static int node, edge;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node];
		visited = new boolean[node];
		for (int i = 0; i < node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for (int i = 0; i < node; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		System.out.println("0");
	}
	
	static void dfs(int head, int cnt) {
		if (cnt >= 5) {
			System.out.println("1");
			System.exit(0);
		}
		
		for (int next : graph[head]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
}
