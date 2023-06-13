package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B_1414 {
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
	static int N, all, cnt, ans;
	static int[][] map;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = convert(str.charAt(j - 1));
				all += map[i][j];
			}
		}
		
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) { // 양방향 그래프 생성 (최소값의)
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue ;
				if (map[i][j] != 0) {
					int cost = Math.min(map[i][j], map[j][i]);
					if (map[j][i] == 0)
						cost = map[i][j];
					
					graph[i].add(new Node(i, j, cost));
					graph[j].add(new Node(j, i, cost));
				}
			}
		}
		
		if (!check()) {
			System.out.println("-1");
			return ;
		}
		
//		System.out.println(all);
		
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			dijk(i);
//			System.out.println("-----------");
//			System.out.println(cnt);
			ans = Math.min(ans, cnt);
		}
		System.out.println(all - ans);

	}
	
	static void dijk(int start) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.offer(new Node(0, start, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int num = cur.to;

			if (!visited[num]) {
				cnt += cur.cost;
//				System.out.println(cur);
//				System.out.println(cnt);
				visited[num] = true;
				for (Node n : graph[num]) {
//					q.offer(new Node(n.from, n.to, n.cost + cur.cost));
					if (!visited[n.to]) {
//						visited[n.to] = true;
						q.offer(n);
					}
				}
			}
		}
	}
	
	static int convert(char c) {
		if (c == '0') return c - '0';
		return ('a' <= c && c <= 'z') ? c - 'a' + 1 : c - 'A' + 27;
	}
	
	static boolean check() {
		Queue<Node> q = new LinkedList<>();
		
		boolean[] visited = new boolean[N + 1];
		q.offer(new Node(0, 1, 0));
		
		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
				
			if (!visited[cur.to]) {
				visited[cur.to] = true; 
				for (Node n : graph[cur.to]) {
					q.offer(n);
				}
				cnt++;
			}
		}
//		System.out.println(cnt);
		if (cnt == N)
			return true;
		else
			return false;
	}
}
