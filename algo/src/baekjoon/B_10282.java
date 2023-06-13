package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_10282 {
	static int n, d, c, cntCost, cnt;
	static ArrayList<Node>[] graph;
	static int[] costs;
	static boolean[] visited;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			costs = new int[n + 1];
			
//			for (int i = 1; i <= n; i++) {
//				graph[i] = new ArrayList<>();
//				costs[i] = Integer.MAX_VALUE;
//			}
			
			Arrays.fill(graph, new ArrayList<>());
			Arrays.fill(costs, Integer.MAX_VALUE);

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				graph[from].add(new Node(to, cost));
			}

			cnt = 0;
			cntCost = 0;
			costs[c] = 0;
			bfs();
			for (int i = 1; i <= n; i++) {
				if (costs[i] != Integer.MAX_VALUE)
					cntCost = Math.max(cntCost, costs[i]);
			}
			System.out.println(cnt + " " + cntCost);
			System.out.println(Arrays.toString(costs));
		}
	}

	static void bfs() {
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(c, 0));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (!visited[cur.to]) {
				visited[cur.to] = true;
//				cntCost += cur.cost;
				cnt++;
				for (Node n : graph[cur.to]) {
					if (costs[n.to] > costs[cur.to] + n.cost) {
						costs[n.to] = costs[cur.to] + n.cost;
						q.offer(new Node(n.to, costs[n.to]));
					}
				}
			}
		}
	}
}
/*
2
3 2 2
2 1 5
3 2 5
3 3 1
2 1 2
3 1 8
3 2 4
 */


