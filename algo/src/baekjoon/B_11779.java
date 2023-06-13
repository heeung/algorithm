package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_11779 {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
	}
	static int node, edge, start, end, minCost, cnt;
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static ArrayList<Node>[] routes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		graph = new ArrayList[node + 1];
		
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(from, to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		routes = new ArrayList[node + 1];
		for (int i = 0; i <= node; i++) {
			routes[i] = new ArrayList<>();
		}
		
		dijk();
		System.out.println(minCost);
//		System.out.println(cnt);
		for (int i = 0; i < routes.length; i++) {
			System.out.println(routes[i].toString());
		}
		ArrayList<Integer> ret = new ArrayList<>();
		while (true) {
			Node cur = routes[end].get(0); // 최소 비용의 루트는 0번째에 저장되어 있을 것.
			ret.add(cur.to);
			end = cur.from;
			if (cur.from == 0) {
				break ;
			}
		}
		System.out.println(ret.size());
		for (int i = ret.size() - 1; i >= 0; i--) {
			System.out.print(ret.get(i) + " ");
		}
	}
	
	static void dijk() {
		visited = new boolean[node + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Node head = new Node(0, start, 0);
		pq.offer(head);
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			routes[cur.to].add(cur); // 경로 정보 저장 (어디에서 어디로 갔는지)
//			cnt++;
			if (cur.to == end) {
				minCost = cur.cost; // 리턴할 최소 비용 저장
				return ;
			}
			if (!visited[cur.to]) {
				visited[cur.to] = true;
				for (Node next : graph[cur.to]) {
					int cost = next.cost + cur.cost;
					pq.offer(new Node(next.from, next.to, cost));
				}
			}
		}
	}

}
