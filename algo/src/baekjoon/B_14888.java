package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_14888 {
	static char[] op;
	static int[] nums;
	static int N;
	static int cnt;
	static int[] opCnt;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		opCnt = new int[4];
		for (int i = 0; i < 4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}

//			System.out.println(Arrays.toString(op));
		boolean[] visited = new boolean[N - 1];
		arr = new ArrayList<>();
		Combination(new char[N - 1], visited, 0);
		Collections.sort(arr);
		System.out.println(arr.get(arr.size() - 1));
		System.out.println(arr.get(0));
	}

	public static void Combination(char[] comb, boolean[] visited, int depth) {
		if (depth == N - 1) {
			sol(comb);
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opCnt[i] > 0) {
				if (i == 0)
					comb[depth] = '+';
				else if (i == 1)
					comb[depth] = '-';
				else if (i == 2)
					comb[depth] = '*';
				else if (i == 3)
					comb[depth] = '/';
				opCnt[i] -= 1;
				Combination(comb, visited, depth + 1);
				opCnt[i] += 1;
				comb[depth] = 0;
			}
		}
	}

	public static void sol(char[] comb) {
		int tmp = nums[0];
		for (int i = 1; i < N; i++) {
			if (comb[i - 1] == '+')
				tmp += nums[i];
			else if (comb[i - 1] == '-')
				tmp -= nums[i];
			else if (comb[i - 1] == '*')
				tmp *= nums[i];
			else if (comb[i - 1] == '/')
				tmp /= nums[i];
		}
		arr.add(tmp);
	}

}
