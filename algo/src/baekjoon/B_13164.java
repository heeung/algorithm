package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_13164 {
	static int N, K;
	static int[] nums, ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new int[N];
		ret = new int[N - 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				ret[i - 1] = nums[i] - nums[i - 1];
			}
		}
		
		if (K == 1) {
			System.out.println(nums[N - 1] - nums[0]);
			return ;
		}
		
		int sum = 0;
		Arrays.sort(ret);
		for (int i = 0; i < (N - 1) - (K - 1); i++) {
			sum += ret[i];
		}
		System.out.println(sum);
	}
}
