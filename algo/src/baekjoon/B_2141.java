package baekjoon;

import java.io.*;
import java.util.*;

public class B_2141 {
	static class Town implements Comparable<Town> {
		int point;
		int cnt;
		public Town(int point, int cnt) {
			this.point = point;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Town o) {
			return this.point - o.point;
		}
	}
	static int[] arr;
	static int N;
	static long sum;
	static ArrayList<Town> towns;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		towns = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int point = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			towns.add(new Town(point, cnt));
			sum += cnt;
		}
		
		Collections.sort(towns);
		long ret = 0;
		for (int i = 0; i < N; i++) {
			ret += towns.get(i).cnt;
			if ((sum + 1) / 2 <= ret) {
				System.out.println(towns.get(i).point);
				return ;
			}
		}
	}

}
