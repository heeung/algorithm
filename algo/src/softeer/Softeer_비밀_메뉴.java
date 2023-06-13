package softeer;

import java.io.*;
import java.util.*;

public class Softeer_비밀_메뉴 {
	static int K, M, N;
	static String[] keyArr, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N < M) {
			System.out.println("normal");
			return ;
		}
		
		st = new StringTokenizer(br.readLine());
		keyArr = new String[M];
		for (int i = 0; i < M; i++) {
			keyArr[i] = st.nextToken();
		}
		
		st = new StringTokenizer(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken();
		}
		
		String s1 = String.join("", keyArr);
		String s2 = String.join("", arr);
		
		if (s2.contains(s1)) {
			System.out.println("secret");
		} else {
			System.out.println("normal");
		}
	}

}
