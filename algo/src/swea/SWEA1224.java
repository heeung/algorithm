package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA1224 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == ')')
					cnt++;
			}
			char[] arr = new char[size - cnt];
			int idx = 0;
			for (int i = 0; i < size; i++) {
				char tmp = str.charAt(i);
				if ('0' <= tmp && tmp <= '9') {
					arr[idx++] = tmp;
				} else {
					if (stack.isEmpty()) {
						stack.push(tmp);
					} else if (tmp == '(') {
						stack.push(tmp);
					} else if (tmp == ')') {
						while (stack.peek() != '(') {
							arr[idx++] = stack.pop();
						}
						stack.pop();
					} else if (tmp == '-' || tmp == '+') {
						if (stack.peek() == '(') {
							stack.push(tmp);
						} else {
							while (!stack.isEmpty() && stack.peek() != '(') {
								arr[idx++] = stack.pop();
							}
							stack.push(tmp);
						}
					} else if (tmp == '/' || tmp == '*') {
						if (stack.peek() == '(' || stack.peek() == '-' || stack.peek() == '+') {
							stack.push(tmp);
						} else {
							while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
								arr[idx++] = stack.pop();
							}
							stack.push(tmp);
						}
					}
				}
			}
			while (!stack.isEmpty()) {
				arr[idx++] = stack.pop();
			}
			Stack<Integer> nums = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				if ('0' <= arr[i] && arr[i] <= '9') {
					nums.push(arr[i] - '0');
				} else {
					int second = nums.pop();
					int first = nums.pop();
					if (arr[i] == '*') {
						nums.push(first * second);
					} else if (arr[i] == '/') {
						nums.push(first / second);
					} else if (arr[i] == '+') {
						nums.push(first + second);
					} else if (arr[i] == '-') {
						nums.push(first - second);
					}
				}
			}
			System.out.printf("#%d %d\n", t + 1, nums.peek());
		}

	}

}
