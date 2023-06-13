package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_행렬찾기 {
	static class Procession implements Comparable<Procession>{
		int i;
		int j;
		int sizeI;
		int sizeJ;
		int size;
		@Override
		public String toString() {
			return " " + sizeI + " " + sizeJ;
		}
		public Procession(int i, int j, int sizeI, int sizeJ) {
			this.i = i;
			this.j = j;
			this.sizeI = sizeI;
			this.sizeJ = sizeJ;
			this.size = sizeI * sizeJ;
		}
		@Override
		public int compareTo(Procession o) {
			if (this.size == o.size) {
				return this.sizeI - o.sizeI;
			}
			return this.size - o.size;
		}
	}
	static int N;
	static int[][] map;
	static PriorityQueue<Procession> pros;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N + 1][N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			pros = new PriorityQueue<>();
			visited = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0 && !visited[i][j])
						getPros(i, j);
				}
			}
			
			System.out.printf("#%d %d", t, pros.size());
			while (!pros.isEmpty()) {
				System.out.print(pros.poll());
			}
			System.out.println();
		}

	}
	
	public static void getPros(int x, int y) {

		int i = x;
		while (i <= N && map[i][y] != 0) {
			for (int jj = y; jj <= N; jj++) {
				if (map[i][jj] == 0)
					break ;
				visited[i][jj] = true;
			}
			i++;
		}
		
		int j = y;
		while (j <= N && map[x][j] != 0) {
			j++;
		}
		
		pros.offer(new Procession(x, y, (i - x), (j - y)));
	}
}
