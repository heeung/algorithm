package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4012 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N;
	static int[][] map;
	static int[] food;
	static boolean[] visited;
	static int cnt, tasteCnt;
	static boolean[] check;
	static int[] dot;
	static int cook, cookA, cookB;
	static ArrayList<Integer> list;
	static int dotIdx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			food = new int[N];
			for (int i = 0; i < N; i++) {
				food[i] = i;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			visited[0] = true;
			check = new boolean[N / 2];
			cnt = 1;
			list = new ArrayList<>();
			combination(1);
			Collections.sort(list);
			System.out.printf("#%d %d\n", t + 1, list.get(0));
		}

	}
	
	public static void combination(int idx) {
		if (idx == 7)
			return ;
		if (cnt == N / 2) {
			cookA = 0;
			cookB = 0;
			sol();
//			System.out.println("cookA : " + cookA);
//			System.out.println("cookB : " + cookB);
			list.add(Math.abs(cookA - cookB));
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				cnt++;
				combination(i + 1);
				cnt--;
				visited[i] = false;
			}
		}
	}
	
	public static void sol() {
		int[] A = new int[N / 2];
		int[] B = new int[N / 2];
		int aIdx = 0;
		int bIdx = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i])
				A[aIdx++] = i;
			else
				B[bIdx++] = i;
		}
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
		dot = new int[2];
		cook = 0;
		dotIdx = 0;
		getTaste(A);
		cookA = cook;
		dotIdx = 0;
		cook = 0;
		getTaste(B);
		cookB = cook;
	}
	
	public static void getTaste(int[] arr) {
		if (tasteCnt == 2) {
			int i = dot[0];
			int j = dot[1];
//			System.out.println("[" + i + "," + j + "]");
			cook += map[i][j];
//			System.out.println(map[i][j]);
			return ;
		}
		
		for (int i = 0; i < N / 2; i++) {
			if (!check[i]) {
				check[i] = true;
				dot[dotIdx++] = arr[i];
				tasteCnt++;
				getTaste(arr);
				dot[--dotIdx] = 0;
				tasteCnt--;
				check[i] = false;
			}
		}
	}

}
