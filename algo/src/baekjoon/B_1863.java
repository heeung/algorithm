package baekjoon;

import java.io.*;
import java.util.*;

public class B_1863 {
	static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int ret = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			while(!stack.empty() && stack.peek() > height){
                ret += 1;
                stack.pop();
            }
            
            if(!stack.empty() && stack.peek() == height || height == 0)
                continue;

            stack.push(height);
		}
		
		System.out.println(ret + stack.size());
	}
}
