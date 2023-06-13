package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			int ret = 1;
			String tmp = br.readLine();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < n; i++) {
				stack.push(a);
			}
			while (!stack.isEmpty()) {
				ret = ret * stack.pop();
			}
			System.out.printf("#%d %d\n", t + 1, ret);
		}
	}

}
