package baekjoon;

import java.io.*;
import java.util.*;

public class B_10800 {
	static class Ball implements Comparable<Ball>{
		int id;
		int color;
		int weight;
		public Ball(int id, int color, int weight) {
			this.id = id;
			this.color = color;
			this.weight = weight;
		}
		@Override
		public int compareTo(Ball o) {
			if (this.weight == o.weight) {
				return this.color - o.color;
			}
			return this.weight - o.weight;
		}
		
	}
	static int N;
	static ArrayList<Ball> balls;
	static int[] sum, ret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		balls = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int color = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			balls.add(new Ball(i, color, weight));
		}
		sum = new int[200001]; // 누적 합 배열 (인덱스는 색)
		ret = new int[N]; // 잡을 수 있는 공 크기 합
		Collections.sort(balls);
		
		int all = 0;
		int preWeight = 0;
		int cntEqual = 1;
		HashMap<Integer, Integer> check = new HashMap<>(); // 같은 컬러였다면 해당 컬러에 나온 개수 더할 map
		
		// 고려할 점.
		// 전 무게랑 같은지. (잡으면 안됨)
		// 색이 같은지.
		for (int i = 0; i < N; i++) {
			Ball now = balls.get(i);
			
			sum[now.color] += now.weight; // sum 배열 (인덱스가 color인)에 무게 더해주기
			all += now.weight; // 전체 무게에 더하기
			
			if (preWeight == now.weight) { // 전 무게랑 같으면 (먹으면 안됨)
				cntEqual++;
				if (check.containsKey(now.color)) { // 같은 컬러였는지 확인하기
					ret[now.id] = all - sum[now.color] - ((cntEqual - (check.get(now.color) + 1)) * now.weight); // 이미 나온 컬러라면 그만큼 계산해주기
				} else {
					ret[now.id] = all - sum[now.color] - ((cntEqual - 1) * now.weight); // 안 나온거면 그냥 계산해주기
				}
			} else { // 전 무게랑 다르면
				check.clear();
				cntEqual = 1;
				ret[now.id] = all - sum[now.color];
			}
			
//			ret[now.id] = all - sum[now.color] - (cntEqual * now.weight);   // 리턴할 배열 (순서가 보장된)에 저장(출력할 거)
			preWeight = now.weight;
			
			if (check.containsKey(now.color)) { // <color, cnt> 로 된 맵에 넣어주기
				check.put(now.color, check.get(now.color) + 1);
			} else {
				check.put(now.color, 1);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			sb.append(ret[i] + "\n");
//			System.out.println(ret[i]);
		}
		System.out.println(sb);
	}

}
