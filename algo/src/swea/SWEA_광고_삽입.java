package swea;

public class SWEA_광고_삽입 {

	public static void main(String[] args) {

		String play_time = "25:00:00";
		String adv_time = "00:01:00";
		String[] logs = { "24:00:01-25:00:00" };
		Solution s = new Solution();
		System.out.println(s.solution(play_time, adv_time, logs));

	}

	static class Solution {
		static int pt, at;
		static long[] timeBar;

		public String solution(String play_time, String adv_time, String[] logs) {
			// 입력으로 들어온 시간 parsing
			pt = getTime(play_time);
			at = getTime(adv_time);
			timeBar = new long[pt + 2];
			// 타임바에 마킹하기
			for (int i = 0; i < logs.length; i++) {
				String[] tmp = logs[i].split("-");
				timeBar[getTime(tmp[0])] += 1;
				timeBar[getTime(tmp[1])] -= 1;
			}

			// 누적합 생성 하기
			for (int i = 1; i < pt + 1; i++)
				timeBar[i] += timeBar[i - 1];

//			System.out.println(Arrays.toString(timeBar));

			// 슬라이딩 윈도우
			long window = 0;
			long maxWindow = 0;
//			System.out.println(at);
			for (int i = 0; i <= at; i++) {
				window += timeBar[i];
				maxWindow = window;
			}
			int maxStart = 0;
			for (int i = 1; i <= (pt + 1) - at; i++) {
				window -= timeBar[i - 1];
				window += timeBar[i + at - 1];
				if (maxWindow < window) {
					maxWindow = window;
					maxStart = i;
				}
			}

//			System.out.println(getStrTime(maxStart));

			return getStrTime(maxStart);
		}

		static int getTime(String str) {
			int sec = 0;

			String[] tmp = str.split(":");
			for (int i = 0; i < 3; i++) {
				int time = (tmp[i].charAt(0) - '0') * 10 + (tmp[i].charAt(1) - '0');
				sec = sec * 60 + time;
			}
			return sec;
		}

		static String getStrTime(int sec) {
			StringBuilder sb = new StringBuilder();

			int H = sec / 3600;
			sb.append(H / 10);
			sb.append(H % 10);
			sb.append(":");
			sec = sec % 3600;
			int M = sec / 60;
			sb.append(M / 10);
			sb.append(M % 10);
			sb.append(":");

			sec = sec % 60;
			int S = sec;
			sb.append(S / 10);
			sb.append(S % 10);

			return sb.toString();
		}
	}
}