package programmers;

import java.io.*;
import java.util.*;

public class P_기능개발 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(s.solution(new int[]{99, 96, 94}, new int[]{1, 3, 4})));
    }



    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> ret = new ArrayList<>();

            int[] arr = convert(progresses, speeds);

            int cnt = 0;
            int left = 0;
            int right = 0;
            int cur = 0;
            while (left < arr.length) {
                cur = arr[left];
                while (right < arr.length && cur >= arr[right]) {
                    cnt++;
                    right++;
                }
                left = right;
                ret.add(cnt);
                cnt = 0;
            }

            int[] answer = new int[ret.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = ret.get(i);
            }

            return answer;
        }

        static int[] convert(int[] progresses, int[] speeds) {
            int[] arr = new int[progresses.length];

            for (int i = 0; i < progresses.length; i++) {
                if ((100 - progresses[i]) % speeds[i] > 0) {
                    arr[i] = (100 - progresses[i]) / speeds[i] + 1;
                } else {
                    arr[i] = (100 - progresses[i]) / speeds[i];
                }
            }
            return arr;
        }
    }
}
