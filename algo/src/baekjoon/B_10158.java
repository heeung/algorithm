package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10158 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		
		int p_quo = (int)(p + t) / w; //가로이동경로 몫
		int p_rem = (p + t) % w; //가로이동경로 나머지
		if(p_quo % 2 == 0) {
			x = p_rem; //짝수번 방향전환했으면 좌표는 정방향
		}else {
			x = w - p_rem; //홀수번 방향전환시 좌표는 거꾸로계산
		}
		
		int q_quo = (int)(q + t) / h;
		int q_rem = (q + t) % h;
		if(q_quo % 2 == 0) {
			y = q_rem;
		}else {
			y = h - q_rem; 
		}
		System.out.println(x + " " + y);
	}
}