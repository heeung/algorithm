package programmers;

public class P_타겟_넘버 {
    public static void main(String[] args) {
        Solution s = new Solution();


    }

    static class Solution {
        static int cnt;

        public int solution(int[] numbers, int target) {
            dfs(0, 0, numbers, target);
            return cnt;
        }

        static void dfs(int cal, int idx, int[] numbers, int target) {
            if (idx == numbers.length) {
                if (cal == target)
                    cnt++;
                return ;
            }
//            if (idx < numbers.length) {
                int cur = cal + numbers[idx];
                dfs(cur, idx + 1, numbers, target);
                cur = cur - ((cal + numbers[idx]) * 2);
                dfs(cur, idx + 1, numbers, target);
//            }
        }
    }
}
