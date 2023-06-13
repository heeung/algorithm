package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606_BFS {

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
		bfs(1);
		System.out.println(max);
	}
	public static void bfs(int head) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(head);
		visited[head] = true;
		
		while (!q.isEmpty()) {
			head = q.poll();			
			for (int i = 0; i < graph[head].size(); i++) {
				if (!visited[graph[head].get(i)]) {
					q.add(graph[head].get(i));
					max++;
					visited[graph[head].get(i)] = true;
				}
			}
		}
	}

}
