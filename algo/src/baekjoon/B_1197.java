package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1197 {
	static class Data implements Comparable<Data> {
		int from;
		int to;
		Long cost;

		public Data(int from, int to, Long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			long res = this.cost - o.cost;
			if (res > 0)
				return 1;
			else if (res < 0)
				return -1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "Data [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

	}

	static int node, edge;
	static int[] parent;
	static PriorityQueue<Data> q;
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		parent = new int[node + 1];
		q = new PriorityQueue<>();

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			Long cost = Long.parseLong(st.nextToken());
			q.offer(new Data(from, to, cost));
		}
		
		for (int i = 1; i <= node; i++) {
			parent[i] = i;
		}

		kruskal();
		System.out.println(ans);
	}

	public static void kruskal() {

		while (!q.isEmpty()) {
			Data cur = q.poll();
//			System.out.println(cur);
			if (find(cur.from) != find(cur.to)) {
				ans += cur.cost;
				union(cur.from, cur.to);
			}
		}
	}

	public static int find(int r) {
		if (parent[r] == r)
			return r;
		return parent[r] = find(parent[r]);
	}

	public static void union(int e1, int e2) {
		int a = find(e1);
		int b = find(e2);

		if (a == b) {
			return;
		}

		if (a > b)
			parent[b] = a;
		else
			parent[a] = b;
	}

}
