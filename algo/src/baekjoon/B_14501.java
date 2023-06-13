package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_14501 {
	static class Task {
		int day;
		int earn;
		public Task(int day, int earn) {
			this.day = day;
			this.earn = earn;
		}
	}
	static int size;
	static boolean[] visited;
	static Task[] tasks;
	static ArrayList<Integer> ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		tasks = new Task[size];
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int earn = Integer.parseInt(st.nextToken());
			tasks[i] = new Task(day, earn);
		}
		 visited = new boolean[size];
		 ret = new ArrayList<>();
		 combination(new Task[size], 0, 0);
		 Collections.sort(ret, Collections.reverseOrder());
		 System.out.println(ret.get(0));
		
	}
	
	public static void combination(Task[] comb, int depth, int day) {
		
		if (day > size) {
			comb[depth - 1] = null;
//			print(comb);
			sol(comb);
			return ;
		} else if (day == size) {
//			print(comb);
			sol(comb);
			return ;
		}
		
		for (int i = day; i < size; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = tasks[i];
				combination(comb, depth + 1, i + tasks[i].day);
				comb[depth] = null;
				visited[i] = false;
			}
		}
		
	}
	public static void print(Task[] comb) {
		int i = 0;
		while (i < size && comb[i] != null) {
			System.out.println("[day : " + comb[i].day + " earn : " + comb[i].earn + "]");
			i++;
		}
		System.out.println();
		
	}
	
	public static void sol(Task[] comb) {
		int i = 0;
		int cnt = 0;
		while (i < size && comb[i] != null) {
			cnt += comb[i].earn;
			i++;
		}
		ret.add(cnt);
	}
}
