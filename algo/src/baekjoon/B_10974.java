package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10974 {
	
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		combination(new int[N], 0);
	}

	static void combination(int[] comb, int depth) {
		if (depth == N) {
			print(comb);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = i;
				combination(comb, depth + 1);
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
