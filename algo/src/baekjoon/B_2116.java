package baekjoon;

import java.io.*;
import java.util.*;

public class B_2116 {
	static int N;
	static int[][] dices;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		// 맨 아래 주사위 6면 확인
		for (int i = 0; i < 6; i++) {
			int upside = i;
			int sum = check(0, i);
			// 나머지 주사위 확인
			for (int dice = 1; dice < N; dice++) {
				upside = findUpsideIndex(dice, upside);
				sum += check(dice, upside);
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
	static int check(int num, int idx) {
		int max = 0;
		if (idx == 0 || idx == 5) {
			for (int i = 0; i < 6; i++) {
				if (i == 0 || i == 5)
					continue;
				max = Math.max(max, dices[num][i]);
			}
		} else if (idx == 1 || idx == 3) {
			for (int i = 0; i < 6; i++) {
				if (i == 1 || i == 3)
					continue;
				max = Math.max(max, dices[num][i]);
			}
		} else {
			for (int i = 0; i < 6; i++) {
				if (i == 2 || i == 4)
					continue;
				max = Math.max(max, dices[num][i]);
			}
		}
		return max;
	}
	
	static int findUpsideIndex(int num, int preUpside) {
		int upside = 0;
		
		for (int i = 0; i < 6; i++) {
			if (dices[num][i] == dices[num - 1][preUpside]) {
				if (i == 0) {
					upside = 5;
				} else if (i == 1) {
					upside = 3;
				} else if (i == 2) {
					upside = 4;
				} else if (i == 3) {
					upside = 1;
				} else if (i == 4) {
					upside = 2;
				} else if (i == 5) {
					upside = 0;
				}
			}
		}
		return upside;
	}

}
