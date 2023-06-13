package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B_11559 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int R = 1;
	static int G = 2;
	static int B = 3;
	static int P = 4;
	static int Y = 5;
	static ArrayList<int[]> tmpList;
//	static int cntBlock;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[12][6];
		for (int i = 11; i >= 0; i--) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				if (str.charAt(j) == '.') {
					map[i][j] = 0;
				}
				else if (str.charAt(j) == 'R')
					map[i][j] = R;
				else if (str.charAt(j) == 'G')
					map[i][j] = G;
				else if (str.charAt(j) == 'B')
					map[i][j] = B;
				else if (str.charAt(j) == 'P')
					map[i][j] = P;
				else if (str.charAt(j) == 'Y')
					map[i][j] = Y;
			}
		}
		System.out.println(cntPuyo());
//		for (int i = 11; i >= 0; i--) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	
	// 한번 터쳤을때 연쇄작용 일어나는 횟수 리턴
	public static int cntPuyo() {
		int cnt = 0;
		while (true) {
			if (puyo()) {
				cnt++;
				reMapping();
				for (int i = 11; i >= 0; i--) {
					System.out.println(Arrays.toString(map[i]));
				}
				System.out.println(cnt + "------------------");
				
			} else {
				return cnt;
			}
		}
	}

	//한사이클 터트리기
	public static boolean puyo() {
		visited = new boolean[12][6];
		boolean flag = false;
		
		for (int i = 0; i < 12; i++) {
			
			for (int j = 0; j < 6; j++) {
				
				if (map[i][j] != 0 && !visited[i][j]) {
					tmpList = new ArrayList<>();
					dfs(i, j, map[i][j]);
					// 만약 dfs돌고 나서 리스트에 4개 이상 들어가있으면 뿌요가능이니까 0으로 만들어주기
					if (tmpList.size() > 3) {
						flag = true;
						for (int[] arr : tmpList)
							map[arr[0]][arr[1]] = 0;
					}
				}
			}
		}
		return flag;
	}
	
	// 상하좌우로 연결된게 몇개있는지 파악
	public static void dfs(int i, int j, int color) {
		visited[i][j] = true;
		int[] tmp = new int[] {i, j};
		tmpList.add(tmp);
		
		for (int d = 0; d < 4; d++) {
			int nextI = i + dy[d];
			int nextJ = j + dx[d];
			
			if (nextI >= 0 && nextJ >= 0 && nextI < 12 && nextJ < 6
					&& !visited[nextI][nextJ] && map[nextI][nextJ] == color) {
				dfs(nextI, nextJ, color);
			}
		}
	}
	
	public static void reMapping() {        
        for (int i = 0; i < 6; i++) {
        	
            for (int j = 0; j < 12; j++) {
                if (map[j][i] == 0) {
                    for (int k = j + 1; k < 12; k++) {
                        if (map[k][i] != 0) {
                            map[j][i] = map[k][i];
                            map[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}
