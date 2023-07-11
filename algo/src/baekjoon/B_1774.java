package baekjoon;

import java.io.*;
import java.util.*;

public class B_1774 {
	static class Point {
		int i, j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class Road implements Comparable<Road> {
		int start, end;
		double cost;

		public Road(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	static int N, M;
	static double ret;
	static Point[] dots;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dots = new Point[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			dots[i] = new Point(x, y);
		}

		// 초기화 과정
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 연결되어있는 통로는 union을 통해서 합쳐준다.
			union(start, end);
		}

		kruskal();
		System.out.printf("%.2f\n", ret);
	}

	static void kruskal() {
		PriorityQueue<Road> pq = new PriorityQueue<>();

		// 모든 연결선 거리 계산
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				Point dot_1 = dots[i];
				Point dot_2 = dots[j];

				double cost = Math.sqrt(Math.pow(dot_1.i - dot_2.i, 2) + Math.pow(dot_1.j - dot_2.j, 2));
				pq.add(new Road(i, j, cost));
			}
		}

		while (!pq.isEmpty()) {
			Road cur = pq.poll();

			// 시작점 그룹과, 끝점 그룹을 합친다.
			if (union(cur.start, cur.end))
				ret += cur.cost;
		}
	}

	// 부모 노드 찾기
	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	// 두 개의 노드가 속한 집합을 연결
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
			return true;
		}
		return false;
	}
}
