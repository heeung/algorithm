package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1182 {
	
	static int N, S, cnt;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		for (int i = 1; i <= N; i++) {
			combination(0, i, 0, 0);
		}
		System.out.println(cnt);
	}

	static void combination(int depth, int size, int sum, int idx) {
		if (depth == size) {
			if (sum == S)
				cnt++;
			return ;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				sum += arr[i];
				visited[i] = true;
				combination(depth + 1, size, sum, i);
				sum -= arr[i];
				visited[i] = false;
			}
		}
	}
}
