package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_6603 {
	
	static int K;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			K = Integer.parseInt(st.nextToken());
			if (K == 0)
				break ;
			
			arr = new int[K];
			for (int i = 0; i < K; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			visited = new boolean[K];
			combination(new int[6], 0, 0);
			System.out.println();
		}
	}

	
	public static void combination(int[] comb, int depth, int idx) {
		
		if (depth == 6) {
			print(comb);
			return ;
		}
		
		for (int i = idx; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = arr[i];
				combination(comb, depth + 1, i);
				visited[i] = false;
			}
			
		}
	}
	
	public static void print(int[] comb) {
		for (int i = 0; i < 6; i++) {
			System.out.print(comb[i] + " ");
		}
		System.out.println();
	}
	
}
