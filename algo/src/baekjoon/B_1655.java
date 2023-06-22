package baekjoon;

import java.io.*;
import java.util.*;

public class B_1655 {
	static int N;
	static PriorityQueue<Integer> leftQ;
	static PriorityQueue<Integer> rightQ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		leftQ = new PriorityQueue<>();
		rightQ = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)  { // 짝수
				rightQ.offer(Integer.parseInt(br.readLine()));
			} else {
				leftQ.offer(Integer.parseInt(br.readLine()));
			}
			
			if (!leftQ.isEmpty() && !rightQ.isEmpty()) {
				if (leftQ.peek() < rightQ.peek()) {
					int tmp = rightQ.poll();
					rightQ.offer(leftQ.poll());
					leftQ.offer(tmp);
				}
			}
			sb.append(rightQ.peek());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
