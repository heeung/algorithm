package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17090 {
	static int sizeI;
	static int sizeJ;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int cnt;
	static boolean done;
	static int[][] save;
	static ArrayList<Integer[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		sizeI = Integer.parseInt(st.nextToken());
		sizeJ = Integer.parseInt(st.nextToken());
		
		map = new char[sizeI][sizeJ];
		for (int i = 0; i < sizeI; i++) {
			String str = br.readLine();
			for (int j = 0; j < sizeJ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[sizeI][sizeJ];
		save = new int[sizeI][sizeJ];
		for (int i = 0; i < sizeI; i++) {
			for (int j = 0; j < sizeJ; j++) {
				list = new ArrayList<>();
				done = true;
				if (save[i][j] == 0) {
					dfs(i, j);
				} else if (save[i][j] == -1) {
					done = false;
					continue ;
				}
				else {
					done = true;
					cnt++;
					continue ;
				}
				if (done == true) {
					for (Integer[] n : list) {
						save[n[0]][n[1]] = 1;
					}
					cnt++;
				}
				else
					for (Integer[] n : list) {
						save[n[0]][n[1]] = -1;
					}
			}
		}
		System.out.println(cnt);
//		for (int i = 0; i < sizeI; i++)
//			System.out.println(Arrays.toString(save[i]));
	}
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		Integer[] tmp = new Integer[] {i, j};
		list.add(tmp);
		
		if (map[i][j] == 'U') {
			int nextI = i + dy[0];
			int nextJ = j + dx[0];
			if (nextI < 0 || nextI >= sizeI || nextJ < 0 || nextJ >= sizeJ) {
				return ;
			}
			if (save[nextI][nextJ] == 1)
				return ;
			if (visited[nextI][nextJ] == true || save[nextI][nextJ] == -1) {
				done = false;
				return ;
			}
			if (nextI >= 0 && nextI < sizeI && nextJ >= 0 && nextJ < sizeJ)
				dfs(nextI, nextJ);
		} else if (map[i][j] == 'R') {
			int nextI = i + dy[1];
			int nextJ = j + dx[1];
			if (nextI < 0 || nextI >= sizeI || nextJ < 0 || nextJ >= sizeJ) {
				return ;
			}
			if (save[nextI][nextJ] == 1)
				return ;
			if (visited[nextI][nextJ] == true || save[nextI][nextJ] == -1) {
				done = false;
				return ;
			}
			if (nextI >= 0 && nextI < sizeI && nextJ >= 0 && nextJ < sizeJ)
				dfs(nextI, nextJ);
		} else if (map[i][j] == 'D') {
			int nextI = i + dy[2];
			int nextJ = j + dx[2];
			if (nextI < 0 || nextI >= sizeI || nextJ < 0 || nextJ >= sizeJ) {
				return ;
			}
			if (save[nextI][nextJ] == 1)
				return ;
			if (visited[nextI][nextJ] == true || save[nextI][nextJ] == -1) {
				done = false;
				return ;
			}
			if (nextI >= 0 && nextI < sizeI && nextJ >= 0 && nextJ < sizeJ)
				dfs(nextI, nextJ);
		} else {
			int nextI = i + dy[3];
			int nextJ = j + dx[3];
			if (nextI < 0 || nextI >= sizeI || nextJ < 0 || nextJ >= sizeJ) {
				return ;
			}
			if (save[nextI][nextJ] == 1)
				return ;
			if (visited[nextI][nextJ] == true || save[nextI][nextJ] == -1) {
				done = false;
				return ;
			}
			if (nextI >= 0 && nextI < sizeI && nextJ >= 0 && nextJ < sizeJ)
				dfs(nextI, nextJ);
		}
	}

}
