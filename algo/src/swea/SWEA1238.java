package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static PriorityQueue<Integer> tmpQ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			st = new StringTokenizer(br.readLine());
			int edge = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			visited = new boolean[101];
			graph = new ArrayList[101];
			tmpQ = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < 101; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < edge / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
			}
			bfs(start);
//			System.out.println(tmpQ);
//			System.out.println(Arrays.toString(arr));
			System.out.printf("#%d %d\n", t + 1, tmpQ.poll());
		}
	}
	
	public static void bfs(int start) {
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			tmpQ.clear();
			for (Integer n : q) {
				tmpQ.offer(n);
			}
			int size = q.size();
			
			for (int a = 0; a < size; a++) {
				int cur = q.poll();
				for (int i = 0; i < graph[cur].size(); i++) {
					int next = graph[cur].get(i);
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			if (q.isEmpty())
				return ;
		}
	}
}
