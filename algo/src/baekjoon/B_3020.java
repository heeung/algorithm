package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3020 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		// 누적합 저장공간, index 값은? 높이
		int[] bottom = new int [H + 1];
		int[] top = new int [H + 1];
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				bottom[Integer.parseInt(br.readLine())]++;
			else
				top[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = H - 1; i >= 1; i--) {
			bottom[i] = bottom[i] + bottom[i + 1];
			top[i] = top[i] + top[i + 1];
		}
		
		int[] cnt = new int[H + 1];
		for (int i = 1; i <= H; i++) {
			int cntB = bottom[i];
			int cntT = top[H - i + 1];
			cnt[i] = cntB + cntT;
		}
		
		int[] ret = new int[N + 1];
		for (int i = 1; i <= H; i++) {
			ret[cnt[i]]++;
		}
		
		for (int j = 0; j <= N; j++) {
			if (ret[j] != 0) {
				System.out.printf("%d %d\n", j, ret[j]);
				break ;
			}
		}
	}

}