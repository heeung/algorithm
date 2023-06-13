package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2564 {

	static class Location {
		int where;
		int dis;

		public Location(int where, int dis) {
			this.where = where;
			this.dis = dis;
		}
	}

	static int W, H, N;
	static Location[] stores;
	static Location me;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		stores = new Location[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stores[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		me = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 내가 위에 있는데?
			if (me.where == 1) {
				// 위쪽에 있으면?
				if (stores[i].where == 1) {
					sum += Math.abs(me.dis - stores[i].dis);
				}
				// 아래쪽에 있으면?
				else if (stores[i].where == 2) {
					int d1 = H;
					int d2 = H;
					d1 += me.dis + stores[i].dis;
					d2 += (W - me.dis) + (W - stores[i].dis);
					sum += Math.min(d1, d2);
				}
				// 왼쪽에 있으면?
				else if (stores[i].where == 3) {
					sum += me.dis;
					sum += stores[i].dis;
				}
				// 오른쪽에 있으면?
				else if (stores[i].where == 4) {
					sum += W - me.dis;
					sum += stores[i].dis;
				}
			}
			// 내가 아래에 있는데?
			if (me.where == 2) {
				// 아래에 있으면?
				if (stores[i].where == 2) {
					sum += Math.abs(me.dis - stores[i].dis);
				}
				// 위쪽에 있으면?
				else if (stores[i].where == 1) {
					int d1 = H;
					int d2 = H;
					d1 += me.dis + stores[i].dis;
					d2 += (W - me.dis) + (W - stores[i].dis);
					sum += Math.min(d1, d2);
				}
				// 왼쪽에 있으면?
				else if (stores[i].where == 3) {
					sum += me.dis;
					sum += H - stores[i].dis;
				}
				// 오른쪽에 있으면?
				else if (stores[i].where == 4) {
					sum += W - me.dis;
					sum += H - stores[i].dis;
				}
			}
			// 내가 왼쪽에 있는데?
			if (me.where == 3) {
				// 왼쪽에 있으면?
				if (stores[i].where == 3) {
					sum += Math.abs(me.dis - stores[i].dis);
				}
				// 오른쪽에 있으면?
				else if (stores[i].where == 4) {
					int d1 = W;
					int d2 = W;
					d1 += me.dis + stores[i].dis;
					d2 += (H - me.dis) + (H - stores[i].dis);
					sum += Math.min(d1, d2);
				}
				// 위쪽에 있으면?
				else if (stores[i].where == 1) {
					sum += me.dis;
					sum += stores[i].dis;
				}
				// 아래쪽에 있으면?
				else if (stores[i].where == 2) {
					sum += H - me.dis;
					sum += stores[i].dis;
				}
			}
			// 내가 오른쪽에 있는데?
			if (me.where == 4) {
				// 오른쪽에 있으면?
				if (stores[i].where == 4) {
					sum += Math.abs(me.dis - stores[i].dis);
				}
				// 왼쪽에 있으면?
				else if (stores[i].where == 3) {
					int d1 = W;
					int d2 = W;
					d1 += me.dis + stores[i].dis;
					d2 += (H - me.dis) + (H - stores[i].dis);
					sum += Math.min(d1, d2);
				}
				// 위쪽에 있으면?
				else if (stores[i].where == 1) {
					sum += me.dis;
					sum += W - stores[i].dis;
				}
				// 아래쪽에 있으면?
				else if (stores[i].where == 2) {
					sum += H - me.dis;
					sum += W - stores[i].dis;
				}
			}
		}
		System.out.println(sum);
	}

}
