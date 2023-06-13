package baekjoon;

import java.util.*;

public class B_11051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] com = new int[1001][1001];
        
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= i; j++){
                if (i == j || j == 0)
                    com[i][j] = 1;
                else
                    com[i][j] = (com[i - 1][j - 1] + com[i - 1][j]) % 10007;
            }
        }
        System.out.print(com[N][K]);
    }
}