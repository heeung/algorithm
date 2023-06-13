package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA1245 {
 
    static int T;
    static int N;
    static int[] X;
    static int[] M;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        int t = 1;
        
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            
            X = new int[N];
            M = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0; i < N; i++) {
                M[i] = Integer.parseInt(st.nextToken());
            }
            
            System.out.printf("#%d",t++);
            for (int i = 0; i < N-1; i++) {
                System.out.printf(" %.10f",solve(i,0,(X[i]+X[i+1])/2,X[i],X[i+1]));
            }
            System.out.println();
        }
    }
    
    static double solve(int idx, int depth, double cur, double left, double right) {
        if (depth == 50)
        	return cur;
        double f = 0.0;
        double val = 0.0;
        
        for (int i = 0; i <= idx; i++) {
            f += (double)M[i] / Math.pow(cur - X[i], 2.0);
        }
        
        for (int i = idx+1; i < N; i++) {
            f -= (double)M[i] / Math.pow(X[i] - cur, 2.0);
        }
        
        if(f < 0) {
            val = solve(idx,depth+1, (left + cur)/2.0, left, cur);
        }
        else if ( f > 0) {
            val = solve(idx,depth+1, (cur + right)/2.0, cur, right);
        }
        else {
            val = cur;
        }
        return val;
    }
 
}