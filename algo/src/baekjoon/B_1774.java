package baekjoon;

import java.io.*;
import java.util.*;

public class B_1774 {
	static class Point {
		int num, i, j;
		public Point(int num, int i, int j) {
			this.num = num;
			this.i = i;
			this.j = j;
		}
	}
	static class Node {
		int from, to;
		double cost;
		public Node(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int N, M;
	static ArrayList<Node>[] graph;
	static Point[] info;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		info = new Point[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			info[i] = new Point(i, x, y);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; i++) {
				
			}
		}
	}
	
	static double distance(Point from, Point to) {
		double d1 = from.i - to.i;
		double d2 = from.j - to.j;
		
		double dis = Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
		return Math.round(dis * 100) / 100.0;
	}
}
