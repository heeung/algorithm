package programmers;

public class 파괴되지_않은_건물 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		public int solution(int[][] board, int[][] skill) {
	        int answer = 0;
	        
	        for (int i = 0; i < skill.length; i++) {
	        	int type = skill[i][0];
	        	int r1 = skill[i][1];
	        	int c1 = skill[i][2];
	        	int r2 = skill[i][3];
	        	int c2 = skill[i][4];
	        	int degree = skill[i][5];
	        	
	        	for (int r = r1; r <= r2; r++) {
	        		for (int c = c1; c <= c2; c++) {
	        			if (type == 1) {
	        				board[r][c] -= degree;
	        			} else {
	        				board[r][c] += degree;
	        			}
	        		}
	        	}
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	        	for (int j = 0; j < board[i].length; j++) {
	        		if (board[i][j] > 0)
	        			answer++;
	        	}
	        }
	        return answer;
	    }
		
//		public static int[][] getMap(int[][] skill, int[][] board) {
//			
//			int N = board.length;
//			int M = board[0].length;
//			int[][] map = new int[N + 1][M + 1];
//			
//			for (int i = 0; i < skill.length; i++) {
//	        	int type = skill[i][0];
//	        	int r1 = skill[i][1];
//	        	int c1 = skill[i][2];
//	        	int r2 = skill[i][3];
//	        	int c2 = skill[i][4];
//	        	int degree = skill[i][5];
//	        	
//	        	if (type == 1) {
//	        		map[r1][c1] -= degree;
//	        		map[r2][c2] -= degree;
//	        	} else {
//	        		map[r1][c1] += degree;
//	        		map[r2][c2] += degree;
//	        	}
//	        }
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//
//				}
//			}
//		}
	}

}
