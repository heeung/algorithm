package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int head = 0;
		int tail = N - 1;
		int hret = 0;
		int tret = 0;
		Long min = Long.MAX_VALUE;

		while (head < tail) {
			long sum = arr[head] + arr[tail];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				hret = head;
				tret = tail;
			}
			if (sum >= 0) {
				tail--;
			} else {
				head++;
			}
		}
		
		System.out.println(arr[hret] + " " + arr[tret]);
	}

}
