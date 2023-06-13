package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16562 {
	static int node, edge, money, sum;
	static int[] cost;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		money = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 친구비용
		cost = new int[node + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= node; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 친구 관계
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		visited = new boolean[node + 1];
		for (int i = 1; i <= node; i++) {
			if (!visited[i]) {
				sum += bfs(i);
			}
		}
		
		if (money < sum) {
			System.out.println("Oh no");
		} else {
			System.out.println(sum);
		}
	}
	
	static int bfs(int start) {
		int min = Integer.MAX_VALUE;
		
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		min = Math.min(min, cost[start]);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					min = Math.min(min, cost[next]);
				}
			}
		}
		return min;
	}
}
