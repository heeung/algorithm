package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class B_1941_25C7 {
	static char[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<int[]> XY;
	static int ret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		XY = new ArrayList<>();
		// 모든 좌표들
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int[] tmp = new int[] {i, j};
				XY.add(tmp);
			}
		}
		// 맵 생성
		for (int i = 0; i < 5; i++)
			map[i] = br.readLine().toCharArray();
		
		
		Combination(new int[7], 0, 0, 7);
		System.out.println(ret);
	}
	
	/* 25C7 뽑기
	 * comb[] : 7칸짜리 빈 껍데기, 다 채운 조합을 bfs돌릴거임.
	 * combIdx : comb배열에 넣을때 인덱스값
	 * XYIdx : XY리스트에 인덱스로 접근할 값
	 * left : depth표현값
	 */
	public static void Combination(int[] comb, int combIdx, int XYIdx, int left) {
		if (left == 0) {
			bfs(comb);
			return ;
		}
		
		if (XYIdx == 25)
			return ;
		
		comb[combIdx] = XYIdx;
		Combination(comb, combIdx + 1, XYIdx + 1, left - 1);
		Combination(comb, combIdx, XYIdx + 1, left);
	}
	
	// 조합된것 판단하기
	public static void bfs(int[] comb) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[7];
		
		q.offer(comb[0]);
		int cnt = 1;
		int cntY = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			int curX = XY.get(cur)[1];
			int curY = XY.get(cur)[0];
			if (map[curY][curX] == 'Y')
				cntY++;
			
			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < 7; i++) {
					int nextX = XY.get(comb[i])[1];
					int nextY = XY.get(comb[i])[0];
					if (!visited[i] && curX + dx[d] == nextX && curY + dy[d] == nextY) {
						visited[i] = true;
						q.offer(comb[i]);
						cnt++;
					}
				}
			}
		}
		if (cnt == 7) {
			if (cntY <= 3) {
				ret++;
			}
		}
	}
}
