package baekjoon;

import java.io.*;
import java.util.*;

public class B_13904 {
	static class Work {
		int days;
		int point;
		public Work(int days, int point) {
			this.days = days;
			this.point = point;
		}
	}
	static Work now;
	static int N, max;
	static ArrayList<Work> works;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		works = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int days = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			works.add(new Work(days, point));
			max = Math.max(days, max);
		}
		
		int ret = 0;
		for (int i = max; i >= 1; i--) {
			now = new Work(0, 0);
			for (Work w : works) {
				if (w.days >= i && w.point > now.point)
					now = w;
			}
			
			ret += now.point;
			works.remove(now);
		}
		
		System.out.println(ret);
	}

}
