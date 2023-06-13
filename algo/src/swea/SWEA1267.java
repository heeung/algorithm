package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267 {
	static int node, edge;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] table;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			graph = new ArrayList[node + 1];
			visited = new boolean[node + 1];
			table = new int[node + 1];
			q = new LinkedList<>();
			
			for (int i = 0; i < node + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < edge; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				table[to]++;
				graph[from].add(to);
			}
	//		System.out.println(Arrays.toString(table));
			for (int i = 1; i <= node; i++) {
				if (table[i] == 0) {
					q.offer(i);
					visited[i] = true;
				}
			}
			System.out.print("#" + (t + 1) + " ");
			sol();
			System.out.println();
		}
	}
	public static void sol() {
		while (!q.isEmpty()) {
			int head = q.poll();
			System.out.print(head + " ");
			for (int i = 0; i < graph[head].size(); i++) {
				int idx = graph[head].get(i);
				table[idx]--;
			}
			for (int i = 1; i <= node; i++) {
				if (table[i] == 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
