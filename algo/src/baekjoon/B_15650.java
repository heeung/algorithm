package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15650 {
	
	static int N, M;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		combination(new int[M], 0, 1);
	}
	
	static void combination(int[] comb, int depth, int idx) {
		
		if (depth == M) {
			print(comb);
			return ;
		}
		
		for (int i = idx; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = i;
				combination(comb, depth + 1, i);
				visited[i] = false;
			}
		}
	}
	
	static void print(int[] comb) {
		for (int i = 0; i < comb.length; i++) {
			System.out.print(comb[i] + " ");
		}
		System.out.println();
	}

}
