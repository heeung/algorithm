package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_보물상자_비밀번호 {
	static int N, K;
	static Queue<Character> q;
	static HashSet<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			q = new LinkedList<>();
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				q.offer(str.charAt(i));
			}

			set = new HashSet<>();

			putInSet();
			ArrayList<Integer> list = new ArrayList<>();
			for (Integer n : set) {
				list.add(n);
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.printf("#%d %d\n", t, list.get(K - 1));
		}
	}

	public static void putInSet() {
		for (int n = 0; n < N / 4; n++) {
			for (int i = 0; i < 4; i++) {
				int sum = 0;
				for (int j = 0; j < N / 4; j++) {
					char cur = q.peek();
					q.offer(q.poll());
					if ('A' <= cur && cur <= 'F') {
						sum = sum * 16 + (cur - 'A' + 10);
					} else {
						sum = sum * 16 + (cur - '0');
					}
				}
				set.add(sum);
			}
			q.offer(q.poll());
		}
	}

}
