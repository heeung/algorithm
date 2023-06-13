package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA1215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int T = 0; T < 10; T++) {
			int N = Integer.parseInt(br.readLine());
			String[][] map = new String[8][8];
			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().split("");
			}
			int cnt = 0;
			//가로부분
			for (int i = 0; i < 8; i++) {
				//전체 확인 부분
				for (int k = 0; k <= 8 - N; k++) {
					int diff = N - 1;
					// 좌우대칭 확인
					for (int j = 0; j < N / 2; j++) {
						//if (map[i][j + k].charAt(0) != map[i][j + diff + k].charAt(0)) {
						if (!map[i][j + k].equals(map[i][j + diff + k])) {
							break ;
						}
						diff -= 2;
					}
					if (diff == -1 && N % 2 == 0) {
						cnt++;
					}
					if (diff == 0 && N % 2 == 1) {
						cnt++;
					}
				}
			}
			
			//세로부분
			for (int i = 0; i < 8; i++) {
				//전체 확인 부분
				for (int k = 0; k <= 8 - N; k++) {
					int diff = N - 1;
					// 좌우대칭 확인
					for (int j = 0; j < N / 2; j++) {
						//if (map[i][j + k].charAt(0) != map[i][j + diff + k].charAt(0)) {
						if (!map[j + k][i].equals(map[j + diff + k][i])) {
							break ;
						}
						diff -= 2;
					}
					if (diff == -1 && N % 2 == 0) {
						cnt++;
					}
					if (diff == 0 && N % 2 == 1) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", T + 1, cnt);
		}

	}

}
