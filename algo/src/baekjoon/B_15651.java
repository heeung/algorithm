package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_15651 {
	
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		combination(new int[M], 0);
		bw.flush();
	}
	
	public static void combination(int[] comb, int depth) throws IOException {
		if (depth == M) {
			print(comb);
			return ;
		}
		
		for (int i = 1; i <= N; i++) {
			comb[depth] = i;
			combination(comb, depth + 1);
		}
	}

	public static void print(int[] comb) throws IOException {
		for (int i = 0; i < comb.length; i++) {
			bw.write(comb[i] + '0');
			bw.write(" ");
		}
		bw.write("\n");
	}
}