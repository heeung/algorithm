package baekjoon;

import java.io.*;
import java.util.*;

public class B_1937 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, max, saveCnt;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {-1, 0, 1, 0};
	static int[][] map;
	static int[][] cntMap;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cntMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(dfs(new Point(i, j)), max);
			}
		}
		
		System.out.println(max);
	}

	public static int dfs(Point head) {
        if (cntMap[head.i][head.j] != 0) {
            return cntMap[head.i][head.j];
        }
        cntMap[head.i][head.j] = 1;
        for (int d = 0; d < 4; d++) {
            int ni = head.i + di[d];
            int nj = head.j + dj[d];
            if(ni >= 0 && nj >= 0 && ni < N && nj < N){
                if(map[ni][nj] > map[head.i][head.j])
                    cntMap[head.i][head.j] = Math.max(cntMap[head.i][head.j], dfs(new Point(ni, nj)) + 1);
            }
        }
        return cntMap[head.i][head.j];
    }
}
