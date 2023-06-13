package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1967 {
	static class Node {
		int from;
		int to;
		int cost;
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int N, sum, ret;
	static ArrayList<Node>[] graph;
	static int[] cntEdge;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		cntEdge = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(from, to, cost));
			graph[to].add(new Node(to, from, cost));
			cntEdge[from]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (cntEdge[i] == 0) {
				sum = 0;
				visited = new boolean[N + 1];
//				sum = graph[i].get(0).cost;
				visited[i] = true;
				dfs(i);
				visited[i] = false;
//				ret = Math.max(ret, sum);
//				System.out.println(i + " : " + ret);
			}
		}
		System.out.println(ret);
	}
	
	static void dfs(int start) {
//		visited[start] = true;
		ret = Math.max(ret, sum);
		
		for (Node n : graph[start]) {
			if (!visited[n.to]) {
				visited[n.to] = true;
				sum += n.cost;
				dfs(n.to);
				sum -= n.cost;
				visited[n.to] = false;
			}
		}
	}

}
