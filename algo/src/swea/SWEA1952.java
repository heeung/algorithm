package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1952 {
	static Month[] months;
	static ArrayList<Integer> list;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int day1Pay = Integer.parseInt(st.nextToken());
			int monthPay = Integer.parseInt(st.nextToken());
			int month3Pay = Integer.parseInt(st.nextToken());
			int yearPay = Integer.parseInt(st.nextToken());

			months = new Month[13];
			months[0] = new Month(0, 0, 0, 0);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				months[i] = new Month(Integer.parseInt(st.nextToken()), day1Pay, monthPay, month3Pay);
			}

			list = new ArrayList<>();
			min = Integer.MAX_VALUE;
			dfs(1, 0);
			System.out.printf("#%d %d\n", t + 1, min);
		}
	}

	// cntPrice : 계속 더해지는 가격
	// month : 몇월 인지
	public static void dfs(int month, int cntPrice) {

		if (month == 13) {
			min = Math.min(cntPrice, min);
			return;
		}

		int price = 0;
		// 뒤로 3달치 최소비용 더한거
		if (month <= 10) {
			price += months[month + 1].getMin();
			price += months[month + 2].getMin();
			price += months[month].getMin();
		}
		// 3달치 최소비용 다 더한거랑 3달이용권이랑 비교했을때 3달 이용권이 더 적은 비용이면
		if (price > months[month].month3Pay) {
			cntPrice += months[month].month3Pay;
			dfs(month + 3, cntPrice);
			cntPrice -= months[month].month3Pay;
		}
		cntPrice += months[month].getMin();
		dfs(month + 1, cntPrice);
		cntPrice -= months[month].getMin();
	}
}

class Month {
	public int day;
	public int day1Pay;
	public int monthPay;
	public int month3Pay;

	public Month(int day, int day1Pay, int monthPay, int month3Pay) {
		this.day = day;
		this.day1Pay = day * day1Pay;
		this.monthPay = monthPay;
		this.month3Pay = month3Pay;
	}

	public int getMin() {
		return day1Pay > monthPay ? monthPay : day1Pay;
	}
}
