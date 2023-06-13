package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_8982 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
		}
		
	}

}