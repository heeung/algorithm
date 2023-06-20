package softeer;

import java.io.*;
import java.util.*;

public class Softeer_출퇴근길 {
	static int node, edge, S, T, cnt;
	static ArrayList<Integer>[] graph;
	static boolean[] visited1, visited2;
	static HashSet<Integer> set, set1, set2, ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[node + 1];
		for (int i = 1; i <= node; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
//		set1 = new HashSet<>();
//		set2 = new HashSet<>();
		ret = new HashSet<>();
		
		bfsGo();
		bfsBack();
		
//		visited = new boolean[node + 1];
//		for (int head : graph[S]) {
//			visited[head] = true;
//			dfsGo(head, new HashSet<>());
//			visited[head] = false;
//		}
//		
//		visited = new boolean[node + 1];
//		for (int head : graph[T]) {
//			visited[head] = true;
//			dfsBack(head, new HashSet<>());
//			visited[head] = false;
//		}
		
//		for(int a : set1) {
//			System.out.println(a);
//		}
//		System.out.println("-------------");
//		for(int a : set2) {
//			System.out.println(a);
//		}
//		
//		for (int a : set2) {
//			if (set1.contains(a)) {
//				ret.add(a);
//			}
//		}
		
		for (int i = 1; i <= node; i++) {
			if (i != S && i != T) {
				if (visited1[i] && visited2[i]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
//		System.out.println(ret.size());
	}
	
	// 고려해야 할 점.
	// 각각 스타트하는 지점은 visited 처리를 하는가?
	// bfs 는 최단거리를 찾는다. 뺑 돌아가는 길도 포함을 시켜야 답이 도출되는가?
//	static void dfsGo(int head, HashSet<Integer> root) {
//		if (set1.contains(head)) {
//			return ;
//		}
//		if (head == S) {
//			for (int a : root) {
//				set1.add(a);
//			}
//		}
//		if (head == T) {
//			for (int a : root) {
//				set1.add(a);
//			}
//			return;
//		}
//		root.add(head);
//		
//		for (int next : graph[head]) {
//			if (!visited[next]) {
//				visited[next] = true;
//				dfsGo(next, root);
//				visited[next] = false;
//			}
//		}
//	}
//	
//	static void dfsBack(int head, HashSet<Integer> root) {
//		if (set2.contains(head)) {
//			return ;
//		}
//		if (head == T) {
//			for (int a : root) {
//				set2.add(a);
//			}
//			return;
//		}
//		if (head == S) {
//			for (int a : root) {
//				set2.add(a);
//			}
//			return;
//		}
//		root.add(head);
//		
//		for (int next : graph[head]) {
//			if (!visited[next]) {
//				visited[next] = true;
//				dfsBack(next, root);
//				visited[next] = false;
//			}
//		}
//	}
	
	static void bfsGo() {
		visited1 = new boolean[node + 1];
		Queue<Integer> q = new LinkedList<>();
		
		visited1[S] = true;
		q.offer(S);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == T)
				continue;
			
			for (int next : graph[cur]) {
				if (!visited1[next]) {
					q.offer(next);
					visited1[next] = true;
					set.add(next);
				}
			}
		}
//		System.out.println(Arrays.toString(visited));
	}
	
	static void bfsBack() {
		visited2 = new boolean[node + 1];
		Queue<Integer> q = new LinkedList<>();
		
		visited2[T] = true;
		q.offer(T);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == S)
				continue;
			
			for (int next : graph[cur]) {
				if (!visited2[next]) {
					q.offer(next);
					visited2[next] = true;
					if (set.contains(next)) {
						ret.add(next);
					}
				}
			}
		}
//		System.out.println(Arrays.toString(visited));
	}
}
