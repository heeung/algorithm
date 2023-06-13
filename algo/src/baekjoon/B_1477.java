package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1477 {
	
	static int N, M, L;
	static ArrayList<Integer> list;

	// 가장 긴 곳 정 중앙에 박는게 제일 유리?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		System.out.println(binarySearch());
	}
	
	// 이진 탐색 돌리기
	// 기준은 사이의 거리!
	// 뽑아내는건 최댓값의 최솟값
	public static int binarySearch() {
		list.add(0);
		list.add(L); // 0, L 을 넣어야 맞음, 하나일때도 되더라
		Collections.sort(list);
		
		int left = 1; //거리가 1 (최소) -> 0일때 /by zero 일어남
		int right = L; //거리가 L (최대)
		
		while (left <= right) {
			int mid = (left + right) / 2; //중앙값은 딱 중간으로
			
			int sum = 0;
			for (int i = 0; i < list.size() - 1; i++)
				sum += (list.get(i + 1) - list.get(i) - 1) / mid;
			if (sum > M)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}

}
