package baekjoon;

import java.io.*;
import java.util.*;

public class B_1939 {
	static class Node implements Comparable<Node> {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}
	}
	static int node, edge, max, start, end;
	static ArrayList<Node>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		graph = new ArrayList[node + 1];
		visited = new boolean[node + 1];
		
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(from, to, cost));
			graph[to].add(new Node(to, from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		max = 1000000001;
		dijk();
		System.out.println(max);
	}
	
	static void dijk() {
		Node s = new Node(0, start, 1000000001);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(s);
		visited[s.to] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			max = Math.min(max, cur.cost);
			if (cur.to == end) {
				return ;
			}
			
			visited[cur.to] = true; 
			for (Node next : graph[cur.to]) {
				if (!visited[next.to]) {
					pq.offer(next);
				}
			}
		}
	}
}
