package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14938 {
	static class Node implements Comparable<Node> {
		int me;
		int to;
		int item;
		int cost;
		public Node(int me, int to, int item, int cost) {
			this.me = me;
			this.to = to;
			this.item = item;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int node, M, edge, max = Integer.MIN_VALUE;
	static ArrayList<Node>[] graph;
	static int[] items;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		items = new int[node + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int item = items[me];
			int cost = Integer.parseInt(st.nextToken());
			
			graph[me].add(new Node(me, to, item, cost));
			graph[to].add(new Node(to, me, item, cost));
		}
		
		for (int i = 1; i <= node; i++) {
			max = Math.max(max, bfs(i));
		}
		System.out.println(max);
	}
	
	static int bfs(int start) {
		int sum = items[start];
		boolean[] visited = new boolean[node + 1];
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		Node first = new Node(0, start, 0, 0);
		q.offer(first);
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.cost <= M)
				sum += cur.item;
			
			if (!visited[cur.to]) {
				visited[cur.to] = true; 
				for (Node n : graph[cur.to]) {
					q.offer(new Node(n.me, n.to, n.item, n.cost + cur.cost));
				}
			}
		}	
		
		return sum;
	}
}
