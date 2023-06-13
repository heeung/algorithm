package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_2606 {

	static int max;
	static int[][] graph;
	static boolean[] visited;
	static int node;
	static int edge;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		graph = new int[node + 2][node + 2];
		visited = new boolean[node + 1];
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		dfs(1);
		System.out.println(max - 1);
		
	}
	public static void dfs(int head) {
		visited[head] = true;
		max += 1;
		
		for (int j = 1; j < node + 1; j++) {
			if (graph[head][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
	}

}
