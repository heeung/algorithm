package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2696 {

	static int M;
	static PriorityQueue<Long> leftQ, rightQ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			M = Integer.parseInt(br.readLine());

			leftQ = new PriorityQueue<>(Collections.reverseOrder());
			rightQ = new PriorityQueue<>();

			long[] arr = new long[M];

			int index = 0;
			for (int i = 0; i < M; i += 10) {
				st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					arr[index++] = Integer.parseInt(st.nextToken());
				}
			}

			int c = 1;
			int cnt = 1;
			System.out.println(M / 2 + 1);
			for (int i = 0; i < M; i++) {
				long now = arr[i];
				long middle = 0;

				// 홀수 번째 면
				if (cnt % 2 == 1) {
					rightQ.offer(now);
					while (leftQ.size() - rightQ.size() != 1) {
						leftQ.offer(rightQ.poll());
					}
					middle = leftQ.peek();
					System.out.print(middle + " ");
					if (c % 10 == 0)
						System.out.println();
					c++;
				}
				// 짝수 번째 면
				else {
					rightQ.offer(now);
					while (leftQ.peek() > rightQ.peek()) {
						long left = leftQ.poll();
						long right = rightQ.poll();
						leftQ.offer(right);
						rightQ.offer(left);
					}
				}
				cnt++;
			}
			System.out.println();
		}
	}
}
