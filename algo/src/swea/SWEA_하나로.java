package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_하나로 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class Kruskal implements Comparable<Kruskal> {
		int from;
		int to;
		double cost;
		public Kruskal(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Kruskal o) {
			double com = this.cost - o.cost;
			if (com > 0)
				return 1;
			else if (com == 0)
				return 0;
			else
				return -1;
		}
		@Override
		public String toString() {
			return "Kruskal [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
	}
	static int N;
	static PriorityQueue<Kruskal> q;
	static Point[] dots;
	static boolean[] visited;
	static int[] parent;
	static double ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			N = Integer.parseInt(br.readLine());
			
			dots = new Point[N];
			
			int[] tmpI = new int[N];
			int[] tmpJ = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tmpI[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tmpJ[i] = Integer.parseInt(st.nextToken());
			}
			
			// i, j 좌표들의 정보를 배열에 넣어주기, 배열의 인덱스가 노드의번호임
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				dots[i] = new Point(tmpI[i], tmpJ[i]);
				parent[i] = i;
			}
			double per = Double.parseDouble(br.readLine());
			
			q = new PriorityQueue<>();
			// 정보들을 뽑아서 우선순위 큐에 넣기 : 100만에 defence
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double cost = Math.pow(dots[i].i - dots[j].i, 2) + Math.pow(dots[i].j - dots[j].j, 2);
					q.offer(new Kruskal(i, j, cost));
				}
			}
//			for (Kruskal k : q) {
//				System.out.println(k);
//			}
			ans = 0;
			kruskal();
//			ans = Math.sqrt(ans);
			System.out.printf("#%d %.0f\n", t, ans * per);
		}
	}
	public static void kruskal() {
		
		while (!q.isEmpty()) {
			Kruskal cur = q.poll();
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
			return ;
		}
		
		if (a > b) 
			parent[b] = a;
		else
			parent[a] = b;
	}

}
