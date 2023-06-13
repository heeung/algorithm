package softeer;

import java.io.*;
import java.util.*;

public class Softeer_지우는_소수를_좋아해 {
	static class Node implements Comparable<Node>{
		int from, to, cost;

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
	static int node, edge, max;
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		
		// 양방향 그래프 생성
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(from, to, cost));
			graph[to].add(new Node(to, from, cost));
		}
		
//		for (int i = 1; i <= node; i++) {
//			Collections.sort(graph[i]);
//		}
		
		dijk();
//		System.out.println(min);
//		System.out.println(max);
		System.out.println(findNextPrime(max));
	}
	
	static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Node start = new Node(0, 1, 0);
		pq.offer(start);
		visited[1] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
//			System.out.println(cur);
			max = Math.max(cur.cost, max);
			
			if (cur.to == node) {
				return ;
			}
			
			visited[cur.to] = true;
			for (Node next : graph[cur.to]) {
				if (!visited[next.to]) {
//				if (next.from != cur.to) {
//					if (next.cost > cur.cost) {
//						pq.offer(next);
//					} else {
//						pq.offer(new Node(next.from, next.to, cur.cost));
//					}
					pq.offer(next);
//					pq.offer(new Node(next.from, next.to, max));
				}
			}
//			}
		}
	}
	
	static int findNextPrime(int num) {
		num++;
		while (num < 2147483647) {
			if (isPrime(num)) 
				return (num);
			num ++;
		}
		return 2147483647;
	}
	
	static boolean isPrime(int num) {
		if (num == 2 || num == 3)
			return true;
		int i = 2;
		while (i <= num / 2) {
			if ((num % i) == 0)
				return false;
			i++;
		}
		return true;
	}
}
