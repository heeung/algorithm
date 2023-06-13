package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class P_이모티콘_할인행사 {

	static class User {
		int percent;
		int limit;
		public User(int percent, int limit) {
			this.percent = percent;
			this.limit = limit;
		}
	}
	static ArrayList<User> userList;
	static int[] discountRate = {10, 20, 30, 40};
	static int size;
	
	public int[] solution(int[][] users, int[] emoticons) {
		userList = new ArrayList<>();
		for (int i = 0; i < users.length; i++) {
			userList.add(new User(users[i][0], users[i][1]));
		}
		size = emoticons.length;
		
		int[] emoticonDiscountRates = new int[emoticons.length];
		
		
		return null;
    }
	
	public static void combination(int[] comb, int depth, int[] emoticons) {
		if (depth == size) {
			System.out.println(Arrays.toString(comb));
			solve(comb, emoticons);
			return;
		}
		for (int i = 0; i < 4; i++) {
			comb[depth] = discountRate[i];
			combination(comb, depth + 1, emoticons);
		}
	}
	
	public static int solve(int[] comb, int[] emoticons) {
		int cnt = 0;
		
		for (User u : userList ) {
			for (int i = 0; i < comb.length; i++) {
				if (u.percent <= comb[i]) {
					cnt += emoticons[i] * comb[i] / 100;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		size = 7;
		
	}
}
