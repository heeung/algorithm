package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14725 {
	static class Node {
		String key;
		HashMap<String, Node> child;
		public Node(String key) {
			this.key = key;
			this.child = new HashMap<>();
		}
	}
	static int N;
	static HashMap<String, Node> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			String[] tmp = new String[node];
			for (int k = 0; k < node; k++) {
				tmp[k] = st.nextToken();
			}
			
			Node preN = null; // 포인터
			for (int n = 0; n < node; n++) {
				Node curN = new Node(tmp[n]);
				if (n == 0) { // 처음 수행인데?
					if (map.containsKey(tmp[n])) { // map주머니에 있다? 그러면 그걸 참조해야 한다!
						preN = map.get(tmp[n]);
					} else { // map이 주머니에 없으면? 넣고 참조한다!
						map.put(tmp[n], curN);
						preN = map.get(tmp[n]);
					}
				} else { // 처음 수행이 아니면?
					if (preN.child.containsKey(tmp[n])) { // 전에 들어왔던 (참조하고있는 부모)의 자식들중 있나 확인
						preN = preN.child.get(tmp[n]);
					} else {
						preN.child.put(tmp[n], curN);
						preN = preN.child.get(tmp[n]);
					}
				}
			}
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (String s : map.keySet()) {
			pq.offer(s);
		}
		while (!pq.isEmpty()) {
			String s = pq.poll();
			System.out.println(s);
			print(map.get(s), 2);
		}
	}
	
	static void print(Node head, int cnt) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (String s : head.child.keySet()) {
			pq.offer(s);
		}
		
		while (!pq.isEmpty()) {
			String s = pq.poll();
			for (int i = 0; i < cnt; i++) {
				System.out.print("-");
			}
			System.out.print(s);
			System.out.println();
			print(head.child.get(s), cnt + 2);
		}
	}

}
