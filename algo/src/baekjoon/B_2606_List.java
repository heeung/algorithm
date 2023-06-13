package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2606_List {

	static ArrayList<Integer>[] graph;
	static int node, edge, max;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[node + 1];
		visited = new boolean[node + 1];
		
		for (int i = 0; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1);
		System.out.println(max - 1);
	}
	
	public static void dfs(int head) {
		visited[head] = true;
		max += 1;
		
		for (int j = 0; j < graph[head].size(); j++) {
			int next = graph[head].get(j);
			if (visited[next] == false) {
				dfs(next);
			}
		}
	}
}
