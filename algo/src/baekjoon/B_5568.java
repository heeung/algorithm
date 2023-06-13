package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_5568 {
	
	static int N, K;
	static int[] card;
	static boolean[] visited;
	static HashSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		card = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		
		set = new HashSet<>();
		combination(new int[K], 0);
		System.out.println(set.size());
	}
	
	public static void combination(int[] comb, int depth) {
		
		if (depth == K) {
			putInSet(comb);
			return ;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = card[i];
				combination(comb, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void putInSet(int[] comb) {
		
		StringBuilder br = new StringBuilder();
		for (int i = 0; i < K; i++) {
			br.append(comb[i]);
		}
		set.add(br.toString());
	}

}
