package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_GNS {
	static class Num implements Comparable<Num>{
		int num;
		String sNum;
		public Num(String sNum) {
			this.sNum = sNum;
			if (sNum.equals("ZRO")) this.num = 0;
			if (sNum.equals("ONE")) this.num = 1;
			if (sNum.equals("TWO")) this.num = 2;
			if (sNum.equals("THR")) this.num = 3;
			if (sNum.equals("FOR")) this.num = 4;
			if (sNum.equals("FIV")) this.num = 5;
			if (sNum.equals("SIX")) this.num = 6;
			if (sNum.equals("SVN")) this.num = 7;
			if (sNum.equals("EGT")) this.num = 8;
			if (sNum.equals("NIN")) this.num = 9;
		}
		@Override
		public int compareTo(Num o) {
			return this.num - o.num;
		}
	}
	static PriorityQueue<Num> nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			nums = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums.offer(new Num(st.nextToken()));
			}
			
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				System.out.print(nums.poll().sNum + " ");
			}
			System.out.println();
		}
	}

}
