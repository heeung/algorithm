package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21608 {
	static class Student {
		int num;
		int i;
		int j;
		int[] love;
		public Student(int num, int[] love) {
			this.num = num;
			this.love = love;
		}
		public void setSeat(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public void goMap() {
			map[this.i][this.j] = this.num; 
		}
		public int getPoint() {
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nextI = i + dy[d];
				int nextJ = j + dx[d];
				if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N) {
					if (retLove(nextI, nextJ))
						cnt++;
				}
			}
			if (cnt == 1)
				return 1;
			if (cnt == 2)
				return 10;
			if (cnt == 3)
				return 100;
			if (cnt == 4)
				return 1000;
			return 0;
		}
		public void findBest() {
			maxLove = Integer.MIN_VALUE;
			maxEmpty = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int Love = 0;
						int Empty = 0;
						for (int d = 0; d < 4; d++) {
							int nextI = i + dy[d];
							int nextJ = j + dx[d];
							if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N) {
								if (map[nextI][nextJ] != 0 && retLove(nextI, nextJ)) {
									Love++;
									continue ;
								}
								if (map[nextI][nextJ] == 0)
									Empty++;
							}
						}
						if (maxLove < Love) {
							maxLove = Love;
							maxEmpty = Empty;
							setSeat(i, j);
							continue ;
						} else if (maxLove == Love) {
							if (maxEmpty < Empty) {
								maxEmpty = Empty;
								setSeat(i, j);
								continue ;
							}
						}
						if (maxLove == Integer.MIN_VALUE && maxEmpty < Empty) {
							maxEmpty = Empty;
							setSeat(i, j);
						}
					}
				}
			}
		}
		public boolean retLove(int i, int j) {
			for (int n = 0; n < 4; n++)
				if (map[i][j] == this.love[n])
					return true;
			return false;
		}
	}
	static int N;
	static int[][] map;
	static ArrayList<Student> list;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int maxLove;
	static int maxEmpty;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Student>();
		map = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] loves = new int[4];
			for (int l = 0; l < 4; l++)
				loves[l] = Integer.parseInt(st.nextToken());
			list.add(new Student(num, loves));
		}
		
		list.get(0).setSeat(1, 1);
		list.get(0).goMap();
		for (int i = 1; i < N * N; i++) {
			list.get(i).findBest();
			list.get(i).goMap();
		} 
		
		int cnt = 0;
		for (Student s : list)
			cnt += s.getPoint();
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(cnt);
	}

}
