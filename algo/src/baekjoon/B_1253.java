package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1253 {
	
	static int N, cnt;
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
		
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				} else if (right == i) {
					right--;
					continue;
				}
				int sum = arr[left] + arr[right];
				if (sum == arr[i]) {
					cnt++;
					break ;
				} else if (sum < arr[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
