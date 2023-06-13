package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_금속막대 {
	static int edge, cnt, max, maxNode;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			edge = Integer.parseInt(br.readLine());
			
			graph = new ArrayList[edge * 3];
			
			for (int i = 1; i < edge * 3; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < edge; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
			}
			
			max = 0;
			maxNode = 0;
			for (int i = 1; i < edge * 3; i++) {
				cnt = 0;
				visited = new boolean[edge * 3];
				visited[i] = true;
				dfs(i);
				if (cnt > max) {
					max = cnt;
					maxNode = i;
				}
			}
			
			visited = new boolean[edge * 3];
			System.out.printf("#%d ", t);
			print(maxNode);
			System.out.println();
			
		}

	}
	public static void dfs(int head) {
		visited[head] = true;
		for (Integer n : graph[head]) {
			if (!visited[n]) {
				visited[n] = true;
				cnt++;
				dfs(n);
				visited[n] = false;
			}
		}
	}
	
	public static void print(int head) {
		visited[head] = true;
		for (Integer n : graph[head]) {
			System.out.print(head + " " + n + " ");
			if (!visited[n]) {
				visited[n] = true;
				print(n);
				visited[n] = false;
			}
		}
	}

}
