package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1219 {
	static int edge;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			edge = Integer.parseInt(st.nextToken());
			visited = new boolean[100];
			graph = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < edge; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
			}
			end = 0;
			dfs(0);
			System.out.printf("#%d %d\n", t + 1, end);
		}
	}
	
	public static void dfs(int head) {
		visited[head] = true;
		if (head == 99) {
			end = 1;
			//return ;
		}
		
		for (int i = 0; i < graph[head].size(); i++) {
			int next = graph[head].get(i);
			if (!visited[next])
				dfs(next);
		}
	}

}
