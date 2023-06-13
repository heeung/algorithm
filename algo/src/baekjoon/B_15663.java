package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_15663 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static HashSet<String> set;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		set = new HashSet<>();
		list = new ArrayList<>();
		combination(new int[M], 0, 0);
		for (String s : set) {
			list.add(s);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int[] arr1 = new int[M];
				String[] tmp1 = o1.split(" ");
				for (int i = 0; i < arr1.length; i++)
					arr1[i] = Integer.parseInt(tmp1[i]);
				int[] arr2 = new int[M];
				String[] tmp2 = o2.split(" ");
				for (int i = 0; i < arr2.length; i++)
					arr2[i] = Integer.parseInt(tmp2[i]);
				
				for (int i = 0; i < M; i++) {
					if (arr1[i] == arr2[i])
						continue ;
					return arr1[i] - arr2[i];
				}
				return 0;
			}
		});
		
//		Collections.sort(list);
		for (String s : list) {
			System.out.println(s);
		}
		
	}
	
	public static void combination(int[] comb, int depth, int idx) {
		if (depth == M) {
			set.add(makeStr(comb));
//			System.out.println(makeStr(comb));
			return ;
		}
		
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = arr[i];
				combination(comb, depth + 1, i);
				visited[i] = false;
			}
		}
	}
	
	public static String makeStr(int[] comb) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < comb.length; i++) {
			sb.append(comb[i]);
			sb.append(" ");
		}
		
		return sb.toString();
	}

}
