package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14719 {
	static int[][] map;
	static int W;
	static int H;
	static int ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				map[H - j - 1][i] = 1;
			}
		}
		
		for (int i = H - 1; i >= 0; i--) {
			for (int j = 1; j < W; j++) {
				if (map[i][j] == 0) {
					int cntPB = cntPossibleBlock(i, j);
					if (cntPB > 0) {
						fill(i, j, cntPB);
					}
				}
			}
		}
		System.out.println(ret);
		
	}

	public static int cntPossibleBlock(int i, int j) {
		if (map[i][j - 1] == 0)
			return 0;
		int cnt = 0;
		for (int nj = j; nj < W; nj++) {
			if (map[i][nj] == 1)
				return cnt;
			cnt++;
		}
		
		return 0;
	}
	
	public static void fill(int i, int j, int block) {
		ret += block;
		while (block-- > 0) {
			map[i][j++] = 1;
		}
	}
	
}
