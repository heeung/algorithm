package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_1043 {
	static int N, M, know, cnt;
	static ArrayList<Integer> knowPeople;
	static HashSet<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		know = Integer.parseInt(st.nextToken());
		if (know == 0) {
			System.out.println(M);
			return ;
		}
		knowPeople = new ArrayList<>();
		for (int i = 0; i < know; i++) {
			knowPeople.add(Integer.parseInt(st.nextToken()));
		}
		
		party = new HashSet[M + 1];
		for (int i = 1; i <= M; i++) {
			party[i] = new HashSet<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		countParty();
		System.out.println(M - cnt);
	}
	
	static void countParty() {
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < knowPeople.size(); j++) {
				if (party[i].contains(knowPeople.get(j))) {
					cnt++;
					break ;
				}
			}
		}
	}
}
