package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15685 {

	static ArrayList<Integer[]> dots;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[] size = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023};
	static ArrayList<Character[]> dirs;
	static int gI, gJ, cnt;
	static boolean map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		dirs = new ArrayList<>();
		dots = new ArrayList<>();
		map = new boolean[101][101];
		getDirs();
		while (t > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			makeDots(i, j, d, g);
			t--;
		}
		for (Integer[] nums : dots) {
//			System.out.println(Arrays.deepToString(nums));
			map[nums[0]][nums[1]] = true;
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					if (map[i][j + 1] && map[i + 1][j + 1] && map[i + 1][j])
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
	public static void makeDots(int i, int j, int d, int g) {
		Character[] arr = dirs.get(g);
		Integer[] first = new Integer[] {i, j};
		dots.add(first);
		dots.add(getDot(i, j, d));
		for (int t = 0; t < size[g]; t++) {
			if (arr[t] == '<') {
				d = d + 1;
			} else {
				d = d - 1;
			}
			dots.add(getDot(gI, gJ, d));
		}
	}
	
	public static Integer[] getDot(int i, int j, int d) {
		int a = i + dx[d % 4];
		int b = j + dy[d % 4];
		gI = a;
		gJ = b;
		Integer[] ret = new Integer[] {a, b};
		return ret;
	}
	
	public static void getDirs() {
		
		for (int i = 0; i <= 10; i++) {
			dirs.add(new Character[size[i]]);
		}
		dirs.get(1)[0] = '<';
		for (int i = 2; i <= 10; i++) {
			for (int j = 0; j < size[i]; j++) {
				if (j < size[i] / 2) {
					dirs.get(i)[j] = dirs.get(i - 1)[j];
				} else if (j == size[i] / 2) {
					dirs.get(i)[j] = '<';
				} else {
					char tmp = dirs.get(i - 1)[size[i] - j - 1];
					if (tmp == '<') {
						dirs.get(i)[j] = '>';
					} else {
						dirs.get(i)[j] = '<';
					}
				}
			}
		}
	}
}