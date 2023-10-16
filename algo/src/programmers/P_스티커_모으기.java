package programmers;

public class P_스티커_모으기 {
    static class Solution {
        public int solution(int sticker[]) {
            int answer = 0;
            if (sticker.length == 1) return sticker[0]; // 스티커 하나면 그거 하나 리턴

            int [] dp = new int[sticker.length];

            // 첫 번째 스티커를 뗐을때
            dp[0] = sticker[0];
            dp[1] = dp[0];
            for (int i = 2; i < sticker.length - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
            }
            answer = dp[sticker.length - 2];

            // 첫 번째 스티커를 안뗐을때
            dp[0] = 0;
            dp[1] = sticker[1];
            for (int i = 2; i < sticker.length; i++) {
                dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
            }
            answer = Math.max(answer, dp[sticker.length - 1]);
            return answer;
        }
    }
}
