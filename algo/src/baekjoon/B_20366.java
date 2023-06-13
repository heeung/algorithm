package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_20366 {
	static int N, sum, min;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		map = new int[N];
		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(map);

		min = Integer.MAX_VALUE;
		for (int i = N - 1; i >= 3; i--) {
			for (int j = 0; j <= i - 3; j++) {
				getMin(j, i);
			}
		}
		System.out.println(min);
	}

	public static void getMin(int left, int right) {
		int com = map[left] + map[right];

		left++;
		right--;
		while (left < right) {
			int now = map[left] + map[right];
			min = Math.min(min, Math.abs(com - now));
			if (com > now)
				left++;
			else if (com < now)
				right--;
			else {
				System.out.println("0");
				System.exit(0);
			}
		}
	}
}
