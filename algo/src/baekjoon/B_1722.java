package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1722 {
	
	static int N, K, cnt;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		if (K == 1) {
			int k = Integer.parseInt(st.nextToken());
		} else {
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		cnt = 1;
		combination(new int[N], 0);
		
	}
	
	public static void combination(int[] comb, int depth) {
		if (depth == N) {
			System.out.print(cnt++ +  " ");
			System.out.println(Arrays.toString(comb));
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = i + 1;
				combination(comb, depth + 1);
				visited[i] = false;
			}
		}
	}

}
