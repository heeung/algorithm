package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11724 {
	static int node;
	static int edge;
	static int[][] graph;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		graph = new int[node + 2][node + 2];
		visited = new boolean[node + 1];
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for (int i = 1; i < node + 1; i++) {
			if (visited[i])
				continue ;
			dfs(i);
			cnt++;
		}
		System.out.println(cnt);
	}
	public static void dfs(int head) {
		visited[head] = true;
		
		for (int i = 0; i < node + 1; i++) {
			if (!visited[i] && graph[head][i] == 1) {
				dfs(i);
			}
		}
	}
}
