package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1216 {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 0; T < 10; T++) {
			String tmp = br.readLine();
			map = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for (int i = 100; i > 0; i--) {
				if (sol(i)) {
					System.out.printf("#%d %d\n", T + 1, i);
					break ;
				}
			}
		}
	}

	public static boolean sol(int l) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j <= 100 - l; j++) {
				if (solRow(i, j, l) || solCol(j, i, l))
					return true;
			}
		}
		return false;
	}

	public static boolean solRow(int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (map[i][j + k] != map[i][j + l - 1 - k])
				return false;
		}
		return true;
	}

	public static boolean solCol(int i, int j, int l) {
		for (int k = 0; k < l / 2; k++) {
			if (map[i + k][j] != map[i + l - 1 - k][j])
				return false;
		}
		return true;
	}

}
