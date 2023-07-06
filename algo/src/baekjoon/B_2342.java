package baekjoon;

import java.io.*;
import java.util.*;

public class B_2342 {
	static int size;
	static int[][][] dp;
	static ArrayList<Integer> dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		// 방향 저장하기
		dir = new ArrayList<>();
		int next = -1;
		while (true) {
			next = Integer.parseInt(st.nextToken());
			if (next == 0)
				break;
			dir.add(next);
		}
		
		size = dir.size();
		dp = new int[size][5][5];
		System.out.println(cal(0, 0, 0));
	}
	
	//탑다운 방식 재귀 (끝 idx를 치고 남은 시퀀스로 계산됨)
	static int cal(int idx, int left, int right) {
		// 끝 인덱스 종료
		if (idx == size) return 0;
		// 0이 아니라면 (이미 갔던 시퀀스) 최소값이 이미 저장되어 있을 것.
		if (dp[idx][left][right] != 0) return dp[idx][left][right];
		
		int next = dir.get(idx);
		// 왼발의 경우
		int scoreL = getCost(left, next) + cal(idx + 1, next, right);
		// 오른발의 경우
		int scoreR = getCost(right, next) + cal(idx + 1, left, next);
		
		dp[idx][left][right] = Math.min(scoreL, scoreR);
		return dp[idx][left][right];
	}
	
	static int getCost(int cur, int next) {
		if (cur == next) return 1;
		else if (cur == 0) return 2;
		else if ((cur + 2) % 4 == next % 4) return 4;
		else return 3;
	}
}
