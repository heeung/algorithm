package baekjoon;

import java.io.*;
import java.util.*;

public class B_1027 {
	static int N;
	static int[] map, ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		ret = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i =0 ; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
			ret[i]++;
			ret[i + 1]++;
			
			double pre = map[i + 1] - map[i];
			for (int j = i + 2; j < N; j++) {
				double inclination = (double) (map[j] - map[i]) / (j - i);
				if (inclination > pre) {
					pre = inclination;
					
					ret[i]++;
					ret[j]++;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ret[i]);
		}
		
		System.out.println(max);
	}
}
