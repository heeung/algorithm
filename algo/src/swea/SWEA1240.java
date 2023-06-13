package swea;

import java.util.*;

public class SWEA1240 {
	static int lastIndex;
	static HashMap<String, Integer> map = new HashMap<>();
	static String[] keys = {"0001101","0011001","0010011","0111101","0100011",
			"0110001","0101111","0111011","0110111","0001011"};
	static int[] values = {0,1,2,3,4,5,6,7,8,9};

	public static void main(String[] args) {

		for(int i=0; i<keys.length; i++) { // map에 암호문과 해당 번호 세팅
			map.put(keys[i], values[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int even = 0;
			int odd = 0;
			int res = 0;
			boolean check = true;
			int cols = sc.nextInt();
			int rows = sc.nextInt();
			for(int i=0; i<cols; i++) {
				String row = sc.next();
				if(row.contains("1") && check) {
					lastIndex = row.lastIndexOf("1");
					String sentence = row.substring(lastIndex-55, lastIndex+1);
					int[] code = new int[8];
					for(int j=0; j<8; j++) {
						String temp = sentence.substring(j*7, j*7+7);
						if ( map.containsKey(temp) ) { // 암호문을 가지고 있다면
							code[j] = map.get(temp);
						}
					}
					odd = 0;
					even = 0;
					res = 0;
					for(int k=0; k<code.length; k=k+2) {
						odd += code[k];
					}
					odd = odd * 3;
					for(int k=1; k<code.length; k=k+2) {
						even += code[k];
					}
					
					if ( ((odd + even) % 10) == 0) {
						for(int k=0; k<code.length; k++) {
							res += code[k];
						}
					}
					System.out.println("#"+tc+" "+res);
					check = false;
				} else {
					row = null;
				}
				
			}
		}
	}
}