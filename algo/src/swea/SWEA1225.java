package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 0; t < 10; t++) {
			String tmp = br.readLine();
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			loopOut:
			while (true) {
				for (int i = 0; i < 5; i++) {
					int pick = q.poll();
					pick -= i + 1;
					if (pick <= 0) {
						q.offer(0);
						break loopOut ;
					}
					q.offer(pick);
				}
			}
			System.out.print("#" + (t + 1) + " ");
			for (Integer i : q) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
