package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11724_List {
	static int node, edge, cnt;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
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
		
		for (int j = 0; j < graph[head].size(); j++) {
			int next = graph[head].get(j);
			if (visited[next] == false) {
				dfs(next);
			}
		}
	}

}
