package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10157 {

	static int C, R;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		if (N <= R) {
			System.out.println("1 " + N);
			return ;
		}
		
		if (N > R * C) {
			System.out.println("0");
			return ;
		}
		
		int[][] map = new int[R][C];
		
		int num = 2;
		int dir = 0;
		int i = 0;
		int j = 0;
		map[0][0] = 1;
		while (num != R * C + 1) {
			int nextI = i + dy[dir % 4];
			int nextJ = j + dx[dir % 4];
			if (nextI < R && nextJ < C && nextI >= 0 && nextJ >= 0 && map[nextI][nextJ] == 0) {
				map[nextI][nextJ] = num;
				i = nextI;
				j = nextJ;
			} else {
				dir++;
				continue ;
			}
			num++;
		}
		
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == N) {
					System.out.println((x + 1) + " " + (y + 1));
				}
			}
		}
		
	}

}
