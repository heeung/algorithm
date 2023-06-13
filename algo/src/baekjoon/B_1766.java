package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1766 {

	static int node, edge;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] table;
	static Stack<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		visited = new boolean[node + 1];
		table = new int[node + 1];
		q = new Stack<>();
		
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			table[to]++;
			graph[from].add(to);
		}
		
//		for (int i = 1; i <= node; i++) {
//			Collections.sort(graph[i], Collections.reverseOrder());
//		}
		
		for (int i = node; i >= 1; i--) {
			if (table[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		sol();
		
	}
	
	public static void sol() {
		
		while (!q.isEmpty()) {
			
			int head = q.pop();
			System.out.print(head + " ");
			for (int i = 0; i < graph[head].size(); i++) {
				int idx = graph[head].get(i);
				table[idx]--;
			}
			for (int i = node; i >= 1; i--) {
				if (table[i] == 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}