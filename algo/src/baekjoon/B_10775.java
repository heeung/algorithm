package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주어진 숫자 이하의 비어있는 공항을 찾고, 비어있으면 -1해줌 -> 타고타고 들어가서...
public class B_10775 {
	static int G, P;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i; // 초기 값 세팅
		}
		
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			int input = Integer.parseInt(br.readLine());
			int empty = find(input); //현재 비어있는 공항 찾기
			
			if (empty == 0) { // 못 찾으면? 끝
				break ;
			}
			
			cnt++;
			union(empty, empty - 1);
		}
		System.out.println(cnt);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) // 둘이 부모가 다르면?
			parent[x] = y; // 연결 시켜주기 ( 어짜피 1아래 공항이랑만 함 )
		System.out.println(x + " " + y + " " + Arrays.toString(parent));
	}
	
	static int find(int x) { // 해당 포트 번호이하 주차 가능한 곳 찾기
		if (x == parent[x])
			return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}