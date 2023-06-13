package softeer;

import java.io.*;
import java.util.*;

public class Softeer_성적_평가 {
	static class Point implements Comparable<Point>{
		int id;
		int point;
		public Point(int id, int point) {
			this.id = id;
			this.point = point;
		}
		@Override
		public int compareTo(Point o) {
			return o.point - this.point;
		}
	}
	static int N;
	static ArrayList<Point>[] points;
	static int[][] ret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		points = new ArrayList[4];
		ret = new int[4][N];
		points[3] = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			points[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				points[i].add(new Point(j, point));
				if (i == 0) {
					points[3].add(new Point(j, point));
				} else {
					points[3].set(j, new Point(j, points[3].get(j).point + point));
				}
			}
		}
		
//		getRanking(points[i], i);
		
		for (int i = 0; i < 4; i++) {
			getRanking(points[i], i);
			for (int j = 0; j < N; j++) {
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void getRanking(ArrayList<Point> arr, int n) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for (int i = 0; i < arr.size(); i++) {
			pq.offer(arr.get(i));
		}
		int rank = 1;
		int prePoint = 0;
		int cntSame = 0;
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if (prePoint == cur.point) {
				cntSame++;
				ret[n][cur.id] = rank - 1; 
			} else {
				rank += cntSame;
				ret[n][cur.id] = rank++;
				cntSame = 0;
			}
			prePoint = cur.point;
		}
	}
}
