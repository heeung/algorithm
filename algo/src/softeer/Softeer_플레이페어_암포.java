package softeer;

import java.util.*;
import java.io.*;

public class Softeer_플레이페어_암포 {
	static String message, key;
	static char[][] board;
	static ArrayList<Character> parsed, ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		message = br.readLine();
		key = br.readLine();

		board = new char[5][5];
		
		keyParsing();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		parsed = new ArrayList<>();
		messageParsing();
//		System.out.println(parsed.toString());
		makePassword();
//		System.out.println(ret.toString());
		for (int i = 0; i < ret.size(); i++) {
			System.out.print(ret.get(i));
		}
		System.out.println();
	}

	static void keyParsing() {
		boolean[] check = new boolean[26];
		
		int idx = 0;
		int charToNum = 0;
		int fillIdx = 0;
		for (int n = 0; n < 25; n++) {
			int i = n / 5;
			int j = n % 5;
			if (idx < key.length()) { // 아직 key 알파벳 다 못쓴경우
				// 문자를 숫자 인덱스로 대응
				charToNum = key.charAt(idx) - 'A';
				if (check[charToNum]) {
					n--;
					idx++;
					continue ;
				}
				board[i][j] = key.charAt(idx++);
				check[charToNum] = true;
				if (charToNum == 'I' - 'A') {
					check[charToNum + 1] = true;
				}
				if (charToNum == 'J' - 'A') {
					check[charToNum - 1] = true;
				}
			} else { // key 알파벳 다 쓴 경우
				if (check[fillIdx]) { // 알파벳 쓴 경우
					fillIdx++;
					n--;
					continue ;
				}
				board[i][j] = (char)(fillIdx + 'A');
				if (fillIdx == 'I' - 'A') {
					check[fillIdx + 1] = true;
				}
				if (fillIdx == 'J' - 'A') {
					check[fillIdx - 1] = true;
				}
				fillIdx++;
			}
		}
	}
	
	static void messageParsing() {
		int t = message.length();
		int index = 0;
		
		while (index < t) {
			if (index == t - 1) {
				parsed.add(message.charAt(index));
				parsed.add('X');
				break;
			}
			char c1 = message.charAt(index);
			char c2 = message.charAt(index + 1);
			if (c1 == c2) {
				if (c1 == 'X') {
					parsed.add(c1);
					parsed.add('Q');
				} else {
					parsed.add(c1);
					parsed.add('X');
				}
				index++;
			} else {
				parsed.add(c1);
				parsed.add(c2);
				index += 2;
			}
		}
	}
	
	static void makePassword() {
		
		ret = new ArrayList<>();
		
		for (int i = 0; i < parsed.size() - 1; i += 2) {
			char c1 = parsed.get(i);
			char c2 = parsed.get(i + 1);
			
			int[] c1Loca = findIJ(c1);
			int[] c2Loca = findIJ(c2);
			
			if (c1Loca[0] == c2Loca[0]) { // 둘이 i값 같은 경우
				int ni1 = c1Loca[0];
				int ni2 = c2Loca[0];
				int nj1 = c1Loca[1] + 1;
				int nj2 = c2Loca[1] + 1;
				
				if (nj1 == 5) {
					nj1 = 0;
					if (ni1 == 5) {
						ni1 = 0;
					}
				}
				if (nj2 == 5) {
					nj2 = 0;
					if (ni2 == 5) {
						ni2 = 0;
					}
				}
				ret.add(board[ni1][nj1]);
				ret.add(board[ni2][nj2]);
			} else if (c1Loca[1] == c2Loca[1]) { // 둘이 j 값 같은 경우
				int ni1 = c1Loca[0] + 1;
				int ni2 = c2Loca[0] + 1;
				int nj1 = c1Loca[1];
				int nj2 = c2Loca[1];
				
				if (ni1 == 5) {
					ni1 = 0;
					if (nj1 == 5) {
						nj1 = 0;
					}
				}
				if (ni2 == 5) {
					ni2 = 0;
					if (nj2 == 5) {
						nj2 = 0;
					}
				}
				ret.add(board[ni1][nj1]);
				ret.add(board[ni2][nj2]);
			} else {
				int ni1 = c1Loca[0];
				int ni2 = c2Loca[0];
				int nj1 = c2Loca[1];
				int nj2 = c1Loca[1];
				
				ret.add(board[ni1][nj1]);
				ret.add(board[ni2][nj2]);
			}
		}
	}
	
	static int[] findIJ(char c) {
		int[] ret = new int[2];
		
		for (int n = 0; n < 25; n++) {
			int i = n / 5;
			int j = n % 5;
			
			if (c == board[i][j]) {
				ret[0] = i;
				ret[1] = j;
			}
		}
		return ret;
	}
}