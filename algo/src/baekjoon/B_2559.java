package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2559 {
	static int N, K;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += arr[i];
			max = cnt;
		}
		for (int i = 1; i < N - K + 1; i++) {
			cnt -= arr[i - 1];
			cnt += arr[i + K - 1];
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
