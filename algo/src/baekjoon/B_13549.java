package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13549 {

	static int N, K;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[200000];
		bfs();
		System.out.println(cnt);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		int[] first = { 0, N };
		q.offer(first);

		visited[N] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[1] == K) {
				cnt = now[0];
				return;
			}
			int[] next1 = { now[0] + 1, now[1] - 1 };
			int[] next2 = { now[0], now[1] * 2 };
			int[] next3 = { now[0] + 1, now[1] + 1 };
			if (next1[1] >= 0 && !visited[next1[1]]) {
				q.offer(next1);
				visited[next1[1]] = true;
			}
			if (0 <= next2[1] && next2[1] <= 100000 && !visited[next2[1]]) {
				q.offer(next2);
				visited[next2[1]] = true;
			}
			if (next3[1] <= 100000 && !visited[next3[1]]) {
				q.offer(next3);
				visited[next3[1]] = true;
			}
		}
	}

}
