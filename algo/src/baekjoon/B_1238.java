package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1238 {
	static class Node implements Comparable<Node> {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int node, edge, c, cntCost;
	static ArrayList<Node>[] graph1;
	static ArrayList<Node>[] graph2;
	static int[] costs1;
	static int[] costs2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		graph1 = new ArrayList[node + 1];
		graph2 = new ArrayList[node + 1];
		costs1 = new int[node + 1];
		costs2 = new int[node + 1];

		for (int i = 1; i <= node; i++) {
			graph1[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		Arrays.fill(costs1, Integer.MAX_VALUE);
		Arrays.fill(costs2, Integer.MAX_VALUE);
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph1[from].add(new Node(to, cost));
			graph2[to].add(new Node(from, cost));
		}

		cntCost = 0;
		costs1[c] = 0;
		costs2[c] = 0;
		bfs1();
		bfs2();
		for (int i = 1; i <= node; i++) {
			cntCost = Math.max(cntCost, costs1[i] + costs2[i]);
		}
		System.out.println(cntCost);
		
	}

	static void bfs1() {
		boolean[] visited = new boolean[node + 1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(c, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int num = cur.to;

			if (!visited[num]) {
				visited[num] = true;
				
				for (Node n : graph1[num]) {
					if (costs1[n.to] > costs1[num] + n.cost) {
						costs1[n.to] = costs1[num] + n.cost;
						q.offer(new Node(n.to, costs1[n.to]));
					}
				}
			}
		}
	}
	
	static void bfs2() {
		boolean[] visited = new boolean[node + 1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(c, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (!visited[cur.to]) {
				visited[cur.to] = true;
				
				for (Node n : graph2[cur.to]) {
					if (costs2[n.to] > costs2[cur.to] + n.cost) {
						costs2[n.to] = costs2[cur.to] + n.cost;
						q.offer(new Node(n.to, costs2[n.to]));
					}
				}
			}
		}
	}
}
