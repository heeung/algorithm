package programmers;

import java.util.*;
import java.io.*;

public class P_야근_지수 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[]{4, 3, 3}));
        System.out.println(s.solution(1, new int[]{2, 1, 2}));
        System.out.println(s.solution(3, new int[]{1, 1}));
    }

    static class Solution {
        public long solution(int n, int[] works) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for (int cur : works) { // 다 넣고보기
                q.offer(cur);
            }

            for (int i = 0; i < n; i++) {
                int cur = q.poll();
                cur--;
                q.offer(cur);
            }

            long result = 0;
            for (int cur : q) {
                if (cur > 0) {
                    result += (long) cur * cur;
                }
            }

            return result;
        }
    }
}
