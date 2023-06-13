package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2628 {
	
	static int N, M;
	static ArrayList<Integer> iNums, jNums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		iNums = new ArrayList<>();
		jNums = new ArrayList<>();
		iNums.add(N);
		iNums.add(0);
		jNums.add(M);
		jNums.add(0);
		int K = Integer.parseInt(br.readLine());
		for (int a = 0; a < K; a++) {
			st = new StringTokenizer(br.readLine());
			int select = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (select == 0) {
				iNums.add(num);
			}
			else {
				jNums.add(num);
			}
			
		}
		Collections.sort(iNums);
		Collections.sort(jNums);
		
		int max = 0;
		for (int i = 0; i < iNums.size() - 1; i++) {
			int sum = iNums.get(i + 1) - iNums.get(i);
			for (int j = 0; j < jNums.size() - 1; j++) {
				int mul = sum * (jNums.get(j + 1) - jNums.get(j));
				max = Math.max(max, mul);
			}
		}
		
		System.out.println(max);
	}
	

}
