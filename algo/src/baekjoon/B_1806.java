package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_1806 {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				arr[i] = Integer.parseInt(st.nextToken());
			} else {
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			}
		}
				
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (arr[i] < S)
				continue ;
			if (i == 0) {
				bw.write("1");
				bw.flush();
				return ;
			}
			int cnt = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] - arr[j] >= S) {
					flag = true;
					break ;
				}
				cnt++;
			}
			min = Math.min(min, cnt);
		}
		
		if (!flag && arr[N - 1] != S)
			bw.write("0");
		else
			bw.write(String.valueOf(min));
		bw.flush();
	}

}
