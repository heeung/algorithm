package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
	
	static int N, sum, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			sum = 0;
			cnt = 0;
			combination();
			System.out.println(cnt);
		}

	}
	
	static void combination() {
		if (sum > N)
			return ;
		
		if (sum == N) {
			cnt++;
			return ;
		}
		for (int i = 1; i <= 3; i++) {
			sum += i;
			combination();
			sum -= i;
		}
	}

}
