package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12919 {
	
	static char[] S, T;
	static int sizeS, sizeT;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine().toCharArray();
		T = br.readLine().toCharArray();

		sizeS = S.length;
		sizeT = T.length;
		dfs(T);
		System.out.println(ans);
	}
	
	static void dfs(char[] head) {
		if (sizeS == sizeT) {
			if (check(head))
				ans = 1;
			return ;
		}
		
		if (head[0] == 'B') {
			sizeT--;
			dfs(change2(head));
			sizeT++;
		}
		
		if (head[sizeT - 1] == 'A'){
			sizeT--;
			dfs(change1(head));
			sizeT++;
		}
	}
	
	// 같은지 안같은지 체크
	static boolean check(char[] arr) {
		for (int i = 0; i < S.length; i++) {
			if (arr[i] != S[i])
				return false;
		}
		return true;
	}
	
	static char[] change1(char[] arr) {
		int l = arr.length;
		char[] ret = new char[l - 1];
		for (int i = 0; i < l - 1; i++)
			ret[i] = arr[i];
		return ret;
	}
	
	static char[] change2(char[] arr) {
		int l = arr.length;
		char[] ret = new char[l - 1];
		for (int i = 0; i < l - 1; i++)
			ret[i] = arr[l - i - 1];
		return ret;
	}
}
