package swea;

import java.util.Scanner;

public class SWEA_보호필름 {
	static int D, W, K;
    static int[][] film; // 필름 
    static int ans; // 최소횟수
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 1; t <= T; t++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            
            film = new int[D][W];
            
            for(int i = 0; i < D; i++) {
                for(int j = 0; j < W; j++)
                	film[i][j] = sc.nextInt();
            }
            
            ans = Integer.MAX_VALUE;
            
            dfs(0, 0);
            
            System.out.printf("#%d %d\n", t, ans);
        }
    }
    
    static void dfs (int idx, int count) {
        if(check()) {
            ans = Math.min(ans, count);
            return;
        }
        
        if(count > ans)
        	return;
        if(idx == D)
        	return;

        int[] copy = new int[W];
        
        for(int i = 0; i < W; i++)
            copy[i] = film[idx][i];
        dfs(idx + 1, count);
        
        for(int i = 0; i < W; i++)
        	film[idx][i] = 0;
        dfs(idx + 1, count + 1);
        
        for(int i = 0; i < W; i++)
        	film[idx][i] = 1;
        dfs(idx + 1, count + 1);
        
        for(int i = 0; i < W; i++)
        	film[idx][i] = copy[i];
    }

    public static boolean check() {
        for(int j = 0; j < W; j++) {
            int count = 1;
            boolean sign = false;
            for(int i = 1; i < D; i++) {
            	
                if(film[i][j] == film[i - 1][j])
                	count++;
                else
                	count = 1;
                
                if(count == K) {
                    sign = true;
                    break;
                }
            }
            if(!sign)
            	return false;
        }
        return true;
    }
}
