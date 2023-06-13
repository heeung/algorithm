package programmers;

import java.util.Arrays;

public class P_양궁대회 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
		s.solution(9, info);
	}
}

class Solution {
	
	static int[] apeach;
	static int[] ans = {-1};
	static int N, max, lionPoint, apeachPoint, diff;
	
    public int[] solution(int n, int[] info) {
        
        apeach = info;
        N = n;
        max = Integer.MIN_VALUE;
        combination(new int[11], 0, 0);
        
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    
    public static void combination(int[] comb, int arrow, int idx) {
//    	if (comb[idx] > apeach[idx] + 1) {
//    		return ;
//    	}
    	
    	if (arrow == N) {
//    		lionPoint = getLionPoint(comb);
//    		apeachPoint = getApeachPoint(comb);
//    		if (lionPoint > apeachPoint) {
//    			if (max <= lionPoint) {
//    				ans = comb.clone();
//    				max = Math.max(lionPoint, max);
//    			}
//    		}
    		
    		getPoints(comb);
//    		System.out.println(Arrays.toString(comb));
//    		System.out.println("lion : " + lionPoint);
//    		System.out.println("apeach : " + apeachPoint);
    		if (lionPoint > apeachPoint) {
    			if (max <= lionPoint - apeachPoint) {
    				ans = comb.clone();
    				max = Math.max(lionPoint - apeachPoint, max);
    			}
    		}
    		return ;
    	}
    	
    	
    	for (int i = 0; i < 11 && comb[i] <= apeach[i]; i++) {
    		comb[i]++;
    		combination(comb, arrow + 1, i);
    		comb[i]--;
    	}
    	
    }
    
    public static void getPoints(int[] comb) {
    	lionPoint  = 0;
		apeachPoint = 0;
		for (int i = 0; i < 11; i++) {
			if (apeach[i] != 0 || comb[i] != 0) {
				if (apeach[i] < comb[i])
					lionPoint += 10 - i;
				else
					apeachPoint += 10 - i;
			}
		}
    }
}
    
//    public static int getLionPoint(int[] comb) {
//    	int point = 0;
//    	for (int i = 0; i < 11; i++) {
//    		if (apeach[i] < comb[i] && comb[i] != 0) {
//    			point += 10 - i;
//    		}
//    	}
//    	return point;
//    }
//    
//    public static int getApeachPoint(int[] comb) {
//    	int point = 0;
//    	for (int i = 0; i < 11; i++) {
//    		if (apeach[i] >= comb[i] && apeach[i] != 0) {
//    			point += 10 - i;
//    		}
//    	}
//    	return point;
//    }
//}