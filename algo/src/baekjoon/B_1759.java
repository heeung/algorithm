package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759 {
	
	static int L, C;
	static char[] arr;
	static boolean[] visited;
	static ArrayList<char[]> ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[C];
		Arrays.sort(arr);
		combination(new char[L], 0, 0);
	}
	
	public static void combination(char[] comb, int idx, int depth) {
		
		if (depth == L) {
			check(comb);
			return ;
		}
		
		for (int i = idx; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = arr[i];
				combination(comb, i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
	public static void check(char[] comb) {
		int cntCor = 0;
		int cntVo = 0;
		for (int i = 0; i < comb.length; i++) {
			if (comb[i] == 'a' || comb[i] == 'i' || comb[i] == 'e' || comb[i] == 'o' || comb[i] == 'u') {
				cntCor++;
			} else {
				cntVo++;
			}
		}
		if (cntCor >= 1 && cntVo >= 2) {
			for (int i = 0; i < comb.length; i++)
				System.out.print(comb[i]);
			System.out.println();
		}
	}

}
