package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_10159 {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		count = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
		}
		
		for (int i = 1; i <= N; i++) {
			count(i);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(N - count[i] - 1);
		}
	}
	
	static void count(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int n : graph[cur]) {
				if (!visited[n]) {
					visited[n] = true;
					
					q.offer(n);
					count[start]++;
					count[n]++;
				}
			}
		}
	}

}