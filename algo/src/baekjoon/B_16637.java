package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16637 {

	static int N;
	static char[] arr;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		max = Integer.MIN_VALUE;
		combination(0, arr[0] - '0');
		System.out.println(max);
	}

	public static void combination(int index, int cal) {
		if (index >= N - 1) {
			max = Math.max(max, cal);
			return ;
		}
		boolean choose = false;
		if (index >= N - 3)
			choose = true;
		
		int result = calculate(cal, arr[index + 2] - '0', arr[index + 1]);
		combination(index + 2, result);
		
		if (!choose) {
			int tmp = calculate(arr[index + 2] - '0', arr[index + 4] - '0', arr[index + 3]);
			int res = calculate(cal, tmp, arr[index + 1]);
			combination(index + 4, res);
		}
	}

	public static int calculate(int a, int b, char op) {
		if (op == '+')
			return a + b;
		else if (op == '-')
			return a - b;
		else if (op == '*')
			return a * b;
		
		return 0;
	}
}
