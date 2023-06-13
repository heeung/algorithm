package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			String tmp = br.readLine();
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int answer = 1;
			for (int i = 0; i < str.length(); i++) {
				char next = str.charAt(i);
				if (next == '(' || next == '{'
						|| next == '<' || next == '[') {
					stack.push(next);
				} else {
					if (next == ')') {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							answer = 0;
							break;
						}
					}
					if (next == ']') {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							answer = 0;
							break;
						}
					}
					if (next == '>') {
						if (stack.peek() == '<') {
							stack.pop();
						} else {
							answer = 0;
							break;
						}
					}
					if (next == '}') {
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							answer = 0;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t + 1, answer);
		}
	}

}
