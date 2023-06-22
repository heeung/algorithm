package baekjoon;

import java.io.*;
import java.util.*;

public class B_1113 {
	static class Point {
		int i, j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, M;
	static int[][] map, check;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		check = new int[N][M];
		int size = 0;
        for(int h = 9; h >= 1; h--) {
            for (int a = 0; a < N; a++) {
            	for (int b = 0; b < M; b++) {
            		check[a][b] = h - map[a][b];
            	}
            }
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(check[i][j] > 0) {
                        size += bfs(new Point(i, j));
                    }
                }
            }
        }
        
        System.out.println(size);
	}
	
	static int bfs(Point start) {
		boolean isPossible = true;
		int size = 1;
		
		Queue<Point> q = new LinkedList<>();
		check[start.i][start.j] = 0; 
		q.offer(start);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				
				if (ni < N && nj < M && ni >= 0 && nj >= 0) {
					if (check[ni][nj] > 0) {
						size += 1;
						check[ni][nj] = 0;
						q.offer(new Point(ni, nj));
					}
				} else {
					isPossible = false;
				}
			}
		}
		if (!isPossible) {
			return 0;			
		}
		else
			return size;
	}
}