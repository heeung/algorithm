package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1697 {
	
	static int N, K;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (K <= N) {
			System.out.println(N - K);
			return ;
		}
		
		min = Integer.MAX_VALUE;
		dfs(N, 0);
		System.out.println(min);

	}
	
	public static void dfs(int n, int time) {
		
		if (n >= K) {
			System.out.println("n : " + n + " time : " + time);
			while (n > K) {
				n--;
				time++;
			}
			min = Math.min(time, min);
			return ;
		}
		
		n += 1;
		time += 1;
		dfs(n, time);
		time -= 1;
		n -= 1;
		
		n *= 2;
		time += 1;
		dfs(n, time);
		time -= 1;
		n /= 2;
		
	}

}
