package baekjoon;

import java.io.*;
import java.util.*;

public class B_9205 {
//	static class Node {
//		int to;
//		int distance;
//		public Node(int to, int distance) {
//			this.to = to;
//			this.distance = distance;
//		}
//	}
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N;
	static Point[] points;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N + 2];
			visited = new boolean[N + 2];
			graph = new ArrayList[N + 2];
			
			for (int i = 0; i < N + 2; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				points[i] = new Point(x, y);
			}
			
			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					int distance = Math.abs(points[i].i - points[j].i) + Math.abs(points[i].j - points[j].j);
					if (distance <= 1000) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			
			System.out.println(bfs() ? "happy" : "sad");
		}
	}
	
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (cur == N + 1) {
				return true;
			}
			
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		return false;
	}

}
