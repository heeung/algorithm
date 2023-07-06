package baekjoon;

import java.io.*;
import java.util.*;

public class B_1781 {
	static class Homework implements Comparable<Homework> {
		int deadline;
		int cupNoodle;
		public Homework(int deadline, int cupNoodle) {
			this.deadline = deadline;
			this.cupNoodle = cupNoodle;
		}
		@Override
		public int compareTo(Homework o) {
			return this.deadline - o.deadline;
		}
	}
	static int N;
	static PriorityQueue<Homework> pq;
	static PriorityQueue<Integer> rq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
		rq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int deadline = Integer.parseInt(st.nextToken());
			int cupNoodle = Integer.parseInt(st.nextToken());
			
			pq.offer(new Homework(deadline, cupNoodle));
		}
		
		while (!pq.isEmpty()) {
			Homework cur = pq.poll();
			rq.offer(cur.cupNoodle);
			
			if (cur.deadline < rq.size()) {
				rq.poll();
			}
		}
		
		int ret = 0;
		while (!rq.isEmpty()) {
			int cur = rq.poll();
			ret += cur;
		}
		System.out.println(ret);
	}

}