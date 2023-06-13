package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3980 {
	
	static int[][] player;
	static boolean[] check;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			player = new int [11][11];
			check = new boolean[11];
			
			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					player[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			combination(0, 0);
			System.out.println(ans);
		}

	}
	
	
	public static void combination(int sum, int position) {
		if (position == 11) {
			ans = Math.max(ans, sum);
			return ;
		}
		
		for (int i = 0; i < 11; i++) {
			if (!check[i] && player[i][position] > 0) {
				check[i] = true;
				sum += player[i][position];
				combination(sum, position + 1);
				check[i] = false;
				sum -= player[i][position];
			}
		}
	}
}
