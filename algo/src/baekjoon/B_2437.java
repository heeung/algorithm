package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2437 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			if (!check(i)) {
				System.out.println(i);
				return ;
			}
		}
	}
	
	static boolean check(int num) {
		int sum = 0;
		for (int i = N - 1; i >= 0; i--) {
			sum += arr[i];
			if (sum > num) {
				sum -= arr[i];
			} else if (sum < num) {
				continue ;
			} else {
				return true;
			}
		}
		return false;
	}

}
