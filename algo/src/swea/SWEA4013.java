package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4013 {
//	static Queue<Integer>[] magnets;
	static LinkedList<Integer>[] magnet;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			magnet = new LinkedList[4];
			// 자석들 정보 입력해주기
			for (int i = 0; i < 4; i++) {
				magnet[i] = new LinkedList<>();
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 8; k++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				boolean[] rotate = new boolean[4];
				
				rotate[num] = true;

				// 0 // 1 마주보고 있는 거 다르면
				if (magnet[0].get(2) != magnet[1].get(6)) {
					rotate[0] = true;
					rotate[1] = true;				
				}
				// 1 // 2마주보고 있는 거 다르면
				if (magnet[1].get(2) != magnet[2].get(6)) {
					rotate[1] = true;
					rotate[2] = true;
				}
				// 2 // 3 마주보고 있는 거 다르면
				if (magnet[2].get(2) != magnet[3].get(6)) {
					rotate[2] = true;
					rotate[3] = true;
				}
				
				for (int k = 0; k < 4; k++) {
					if (rotate[k]) {
						if (num % 2 == k % 2) {
							rotation(k, dir);
						} else {
							rotation(k, -dir);
						}
					}
				}
			}
			
			int result = 0;
			for (int i = 0; i < 4; i++) {
				result += magnet[i].get(0) * Math.pow(2, i);
			}
			System.out.println(result);
		}

	}
	
	public static void rotation(int num, int dir) {
		if (dir == -1) {
			magnet[num].offerLast(magnet[num].pollFirst());
		} else {
			magnet[num].offerFirst(magnet[num].pollLast());
		}
	}
}
