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

public class SWEA5644 {
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static class BatteryCharger {
		int i;
		int j;
		int range;
		int P;
		boolean[][] bcRange;
		
		public BatteryCharger(int i, int j, int range, int p) {
			this.i = i - 1;
			this.j = j - 1;
			this.range = range;
			P = p;
			getBcRange();
		}
		
		public void getBcRange() {
			bcRange = new boolean[10][10];
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(this.i, this.j));
			bcRange[this.i][this.j] = true;
			
			for (int t = 0; t < this.range; t++) {
				ArrayList<Point> arr = new ArrayList<>();
				while (!q.isEmpty())
					arr.add(q.poll());
				
				for (Point cur : arr) {
					for (int d = 1; d <= 4; d++) {
						int nextI = cur.i + dy[d];
						int nextJ = cur.j + dx[d];
						if (nextI >= 0 && nextJ >= 0 && nextI < 10 && nextJ < 10 && !bcRange[nextI][nextJ]) {
							bcRange[nextI][nextJ] = true;
							q.offer(new Point(nextI, nextJ));
						}
					}
				}
			}
		}
	}
	static int[][] map;
	static ArrayList<BatteryCharger> BC;
	static int time, cntBC;
	static int N = 10;
	static int[] A;
	static int[] B;
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	static int totalPower;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			cntBC = Integer.parseInt(st.nextToken());
			
			A = new int[time + 1];
			B = new int[time + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= time; i++)
				A[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= time; i++)
				B[i] = Integer.parseInt(st.nextToken());
			
			BC = new ArrayList<>();
			for (int i = 0; i < cntBC; i++) {
				st = new StringTokenizer(br.readLine());
				int tmpI = Integer.parseInt(st.nextToken());
				int tmpJ = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				BC.add(new BatteryCharger(tmpI, tmpJ, range, p));
			}
			
//			for (BatteryCharger bc : BC) {
//				for (int i = 0; i < 10; i++) {
//					for (int j = 0; j < 10; j++) {
//						if (bc.bcRange[i][j])
//							System.out.print(1 + " ");
//						else
//							System.out.print(0 + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			totalPower = 0;
			go();
			System.out.printf("#%d %d\n", t + 1, totalPower);
		}
	}
	public static void go() {
		Point personA = new Point(0, 0);
		Point personB = new Point(9, 9);
		for (int t = 0; t <= time; t++) {
			int dirA = A[t];
			int dirB = B[t];
			Point nextA = new Point(personA.i + dy[dirA], personA.j + dx[dirA]);
			Point nextB = new Point(personB.i + dy[dirB], personB.j + dx[dirB]);
			ArrayList<Integer> checkP = new ArrayList<>();
			int i = 0;
			for (BatteryCharger bc : BC) {
				boolean check = false;
				// A가 범위에 들어와있다.
				if (bc.bcRange[nextA.i][nextA.j]) {
					check = true;
				}
				// B가 범위에 들어와있다.
				if (bc.bcRange[nextB.i][nextB.j]) {
					check = true;
				}
				if (check)
					checkP.add(bc.P);
				personA = nextA;
				personB = nextB;
				i++;
			}
			Collections.sort(checkP, Collections.reverseOrder());
			System.out.println(t);
			for (Integer n : checkP) {
				System.out.println(checkP);
			}
//			for (int a = 0; a < 2; a++) {
//				if (a < checkP.size() && checkP.get(a) != null)
//					totalPower += checkP.get(a);
//			}
			int cnt = 0;
			for (Integer n : checkP) {
				if (cnt == 2)
					break ;
				totalPower += n;
				cnt++;
			}
			System.out.println("total : " + totalPower);
		}
	}

}

//class BatteryCharger {
//	int i;
//	int j;
//	int range;
//	int P;
//	boolean[][] bcRange;
//	
//	public BatteryCharger(int i, int j, int range, int p) {
//		this.i = i;
//		this.j = j;
//		this.range = range;
//		P = p;
//		getBcRange();
//	}
//	
//	public void getBcRange() {
//		bcRange = new boolean[10][10];
//		Queue<Point> q = new LinkedList<>();
//		q.offer(new Point(this.i, this.j));
//		
//		for (int t = 0; t < this.range; t++) {
//			ArrayList<Point> arr = new ArrayList<>();
//			while (!q.isEmpty()) {
//				arr.add(q.poll());
//			}
//			for (Point cur : arr) {
//				for (int d = 1; d <= 4; d++) {
//					int nextI = cur.i + dy[d];
//					int nextJ = cur.j + dx[d];
//				}
//			}
//		}
//	}
//}

//static class Point {
//	int i;
//	int j;
//	public Point(int i, int j) {
//		this.i = i;
//		this.j = j;
//	}
//}