package softeer;
import java.util.*;
import java.io.*;


public class Softeer_super
{
    private static int N;
    private static long B, leastPerform;
    private static long[] compPerform;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        B = Long.parseLong(tmp[1]);

        compPerform = new long[N];
        tmp = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            compPerform[i] = Long.parseLong(tmp[i]);
        }

        leastPerform = compPerform[0];
        solve();
        System.out.println(leastPerform);
    }

    private static void solve() {
        // 오름차순으로 정렬하고 낮은 수 부터 얼마나 최대로 높힐 수 있는지 확인하자
        Arrays.sort(compPerform);

        long start, end, middle;
        start = compPerform[0];
//        end = (long) (compPerform[N-1] + Math.sqrt(B));
        end = Integer.MAX_VALUE;
        while(start <= end) {
            middle = (start + end)/2;
            System.out.println(middle);
            if(check(middle) <= B) {
                leastPerform = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }

    private static long check(long height) {
        long cnt = 0;
        for(int i = 0; i < N; i++) {
            if(compPerform[i] < height) {
                cnt += Math.pow(height - compPerform[i], 2);
            }
        }
        return cnt;
    }
}