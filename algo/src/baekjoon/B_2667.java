package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B_2667 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int size, areaCnt, idx;
	static boolean[][] visited;
	static Integer[][] map;
	static ArrayList<Integer> areaSize;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		visited = new boolean[size][size];
		map = new Integer[size][size];
		// 맵 생성
		for (int i = 0; i < size; i++) {
			String str[] = br.readLine().split("");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		areaSize = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					areaSize.add(0);
					dfs(i, j);
					areaCnt++;
				}
			}
		}
		System.out.println(areaCnt);
		Collections.sort(areaSize);
		for (Integer num : areaSize) {
			System.out.println(num);
		}
	}
	
	public static void dfs(int i, int j) {
		areaSize.set(areaCnt, areaSize.get(areaCnt) + 1);
		
		visited[i][j] = true;
		for (int a = 0; a < 4; a++) {
			int ni = i + dy[a];
			int nj = j + dx[a];
			
			if (ni < size && ni >= 0 && nj < size && nj >= 0
					&& map[ni][nj] == 1 && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}

}
