package baekjoon;

import java.io.*;
import java.util.*;

public class B_1082 {
	static int M, N;
	static int[] costs;
	static ArrayList<Integer> ret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		costs = new int[N];
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		
		ret = new ArrayList<>();
		for (int i = N - 1; i >= 0; i--) {
			
		}
	}

}
