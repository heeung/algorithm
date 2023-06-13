package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class Dice {
		int top;
		int bottom;
		int n;
		int e;
		int s;
		int w;
		public Dice(int top, int bottom, int n, int e, int s, int w) {
			this.top = top;
			this.bottom = bottom;
			this.n = n;
			this.e = e;
			this.s = s;
			this.w = w;
		}
		public Dice roll(int dir) {
			if (dir == 3) { // 북쪽으로 굴리기
				return new Dice(this.s, this.n, this.top, this.e, this.bottom, this.w);			
			} else if (dir == 1) { // 동쪽으로 굴리기
				return new Dice(this.w, this.e, this.n, this.top, this.s, this.bottom);			
			} else if (dir == 4) { // 남쪽으로 굴리기
				return new Dice(this.n, this.s, this.bottom, this.e, this.top, this.w);			
			} else if (dir == 2) { // 서쪽으로 굴리기
				return new Dice(this.e, this.w, this.n, this.bottom, this.s, this.top);			
			} else {
				return null;
			}
		}
		
	}
	static int N, M, K;
	static Point now;
	static int[][] map;
	static Dice dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new Dice(0, 0, 0, 0, 0, 0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			rollDice(Integer.parseInt(st.nextToken()));
		}

	}
	public static void rollDice(int dir) {
		if (dir == 1) { // 동쪽 굴리기
			if (now.j + 1 < M) {
				now.j += 1;
				dice = dice.roll(dir);
				if (map[now.i][now.j] == 0) {
					map[now.i][now.j] = dice.bottom; 
				}
				else {
					dice.bottom = map[now.i][now.j];
					map[now.i][now.j] = 0;
				}
				System.out.println(dice.top);
			}
		}
		if (dir == 2) { // 서쪽 굴리기
			if (now.j - 1 >= 0) {
				now.j -= 1;
				dice = dice.roll(dir);
				if (map[now.i][now.j] == 0) {
					map[now.i][now.j] = dice.bottom; 
				}
				else {
					dice.bottom = map[now.i][now.j];
					map[now.i][now.j] = 0;
				}
				System.out.println(dice.top);
			}
		}
		if (dir == 3) { // 북쪽 굴리기
			if (now.i - 1 >= 0) {
				now.i -= 1;
				dice = dice.roll(dir);
				if (map[now.i][now.j] == 0) {
					map[now.i][now.j] = dice.bottom; 
				}
				else {
					dice.bottom = map[now.i][now.j];
					map[now.i][now.j] = 0;
				}
				System.out.println(dice.top);
			}
		}
		if (dir == 4) { // 남쪽 굴리기
			if (now.i + 1 < N) {
				now.i += 1;
				dice = dice.roll(dir);
				if (map[now.i][now.j] == 0) {
					map[now.i][now.j] = dice.bottom; 
				}
				else {
					dice.bottom = map[now.i][now.j];
					map[now.i][now.j] = 0;
				}
				System.out.println(dice.top);
			}
		}
	}

}
