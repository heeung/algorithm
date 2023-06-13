package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1 은 N극, 아래로 가려는 성질
 * 2 는 S극, 위로 가려는 성질
 */
public class SWEA1220 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int T = 0; T < 10; T++) {
			String[][] map = new String[100][100];
			String temp = br.readLine();
			
			for (int i = 0; i < 100; i++) {
				map[i] = br.readLine().split(" ");
			}
			int allCnt = 0;
			for (int i = 0; i < 100; i++) {
//				String[] arr = new String[100];
				int cnt = 0;
				Stack<String> stack = new Stack<>();
				for (int j = 0; j < 100; j++) {
//					arr[j] = map[j][i];
					if (map[j][i].equals("1")) {
						if (stack.empty()) {
							stack.push(map[j][i]);
						} else if (stack.peek().equals("1")) {
							stack.push(map[j][i]);
						} else {
							stack.clear();
							cnt++;
							stack.push(map[j][i]);
						}
					} else if (map[j][i].equals("2")) {
						if (!stack.empty() && stack.peek().equals("1")) {
							stack.push(map[j][i]);
						} else if (!stack.empty() && stack.peek().equals("2")) {
							stack.push(map[j][i]);
						}
					}
				}
				if (stack.peek().equals("2"))
					cnt++;
				allCnt += cnt;
			}
			System.out.printf("#%d %d\n", T + 1, allCnt);
		}
	}

}
