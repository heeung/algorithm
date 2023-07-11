package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2138 {
	static int N;
	static boolean[] arr, goal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new boolean[N];
		goal = new boolean[N];

		
	}

	static void switching(int cur, int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (-1 < i && i < N) {

			}
		}
	}
}
