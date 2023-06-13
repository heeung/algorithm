package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_가능한시험점수 {
	static int N;
	static int[] points;
	static Set<Integer> s;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new int[N];
			arr = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points[i] = Integer.parseInt(st.nextToken());
			}
			
			s = new HashSet<>();
			s.add(0);
			arr.add(0);
			check(0);
			System.out.printf("#%d %d\n", t ,s.size());
		}
	}
	
	private static void check(int cnt) {
		if(cnt == N) {
			return;
		}
		int len = arr.size();
		for (int i = 0; i < len; i++) {
			if(!s.contains(arr.get(i)+points[cnt])) {
				s.add(arr.get(i)+points[cnt]);
				arr.add(arr.get(i)+points[cnt]);
			}
		}
		check(cnt+1);
	}
}
