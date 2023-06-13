package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			st = new StringTokenizer(br.readLine());
			String size = st.nextToken();
			String num = st.nextToken();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < num.length(); i++) {
				if (stack.isEmpty()) {
					stack.push(num.charAt(i));
				} else {
					if (stack.peek() == num.charAt(i)) {
						stack.pop();
					} else {
						stack.push(num.charAt(i));
					}
				}
			}
			Stack<Character> tmp = new Stack<>();
			while(!stack.isEmpty()) {
				tmp.push(stack.pop());
			}
			System.out.print("#" + (t + 1) + " ");
			while (!tmp.isEmpty()) {
				System.out.print(tmp.pop());
			}
			System.out.println();
		}
	}

}
