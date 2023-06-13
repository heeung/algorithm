package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2212 {
	
	static int K, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		int[] sensor = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < N - 1; i++) {
			q.offer(sensor[i + 1] - sensor[i]);
		}
		int cnt = 0;
		for (int i = 0; i < N - 1 - (K - 1); i++) {
			cnt += q.poll();
		}
		System.out.println(cnt);
	}

}