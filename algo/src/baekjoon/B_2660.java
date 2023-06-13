package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2660 {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		count = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from == -1 && to == -1)
				break;

			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			count(i);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			min = Math.min(min, count[i] - 1);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (min == count[i] - 1) {
				arr.add(i);
			}
		}
		
		System.out.println(min + " " + arr.size());
		for (int n : arr) {
			System.out.print(n + " ");
		}

	}

	static void count(int start) {
		Queue<Integer> q = new LinkedList<>();

		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			ArrayList<Integer> arr = new ArrayList<>();
			while (!q.isEmpty())
				arr.add(q.poll());

			for (int cur : arr) {

				for (int n : graph[cur]) {
					if (!visited[n]) {
						visited[n] = true;

						q.offer(n);
					}
				}
			}
			count[start]++;
		}
	}
}