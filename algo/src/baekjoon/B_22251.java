package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_22251 {
	static int N, K, P, X, cnt, ret, check;
	static int[][] cost = new int[10][10];
	static int[][] nums = { { 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1 } };
	static int[] tmaxFloor, nowFloor, maxFloor;
	static int curFloor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		// N : 층수
		N = Integer.parseInt(st.nextToken());
		// K : 최대 자리 수
		K = Integer.parseInt(st.nextToken());
		// P : 최대 반전 개수
		P = Integer.parseInt(st.nextToken());
		// X : 지금 멈춰 있는 층
		X = Integer.parseInt(st.nextToken());

		makeCostArr();
//		System.out.println("    0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
//		System.out.println();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + "  " + Arrays.toString(cost[i]));
//		}

		int tmpN = N;
		tmaxFloor = new int[K];
		for (int i = K - 1; i >= 0; i--) {
			tmaxFloor[i] = tmpN % 10;
			tmpN = tmpN / 10;
			if (tmpN == 0) {
				K = K - i;
				break;
			}
		}

		maxFloor = new int[K];
		for (int i = K - 1; i >= 0; i--) {
			maxFloor[i] = tmaxFloor[i + tmaxFloor.length - K];
		}

		nowFloor = new int[K];
		for (int i = K - 1; i >= 0; i--) {
			nowFloor[i] = X % 10;
			X = X / 10;
		}
		solve(0);
		System.out.println(ret - 1);
	}

	public static void makeCostArr() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j)
					continue;
				cost[i][j] = getDiff(i, j);
			}
		}
	}

	public static int getDiff(int from, int to) {
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			if (nums[from][i] != nums[to][i]) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void solve(int depth) {

		if (depth == K) {
			if (check == 0 || curFloor > N)
				return;
			if (cnt <= P)
				ret++;
			return;
		}

		if (cnt > P)
			return;

		if (depth == 0) {
			for (int i = 0; i <= maxFloor[0]; i++) {
				cnt += cost[nowFloor[depth]][i];
				check += i;
				curFloor = curFloor * 10 + i;
				solve(depth + 1);
				curFloor = curFloor / 10;
				cnt -= cost[nowFloor[depth]][i];
			}
		} else {
			for (int i = 0; i < 10; i++) {
				cnt += cost[nowFloor[depth]][i];
				check += i;
				curFloor = curFloor * 10 + i;
				solve(depth + 1);
				curFloor = curFloor / 10;
				cnt -= cost[nowFloor[depth]][i];
			}
		}
	}

	public static void solve2(int depth) {
		
		if (cnt > P)
			return ;

		if (depth == K) {
			ret++;
			return;
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(maxFloor[0] + " " + depth + " " + i);
			cnt += cost[nowFloor[depth]][i];
			solve2(depth + 1);
			cnt -= cost[nowFloor[depth]][i];
		}
	}

}
