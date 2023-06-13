package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1135 {
	static class Node implements Comparable<Node> {
		int idx;
		int parent;
		int childSize;
		ArrayList<Node> child = new ArrayList<>();
		
		public Node(int idx) {
			this.idx = idx;
		}
		
		public void setParent(int parent) {
			this.parent = parent;
			nodes[parent].child.add(nodes[this.idx]);
		}

		@Override
		public int compareTo(Node o) {
			return o.childSize - this.childSize;
		}
	}
	static int N, cnt;
	static Node[] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
		st = new StringTokenizer(br.readLine());
		nodes[0].parent = -1;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (i > 0)
				nodes[i].setParent(parent);
		}
		
		// size 세주기
		for (int i = 0; i < N; i++) {
			int parent = nodes[i].parent;
			
			while (parent != -1) {
				nodes[parent].childSize++;
				parent = nodes[parent].parent;
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(i + " : " + nodes[i].childSize);
		}
	}
	
	public static void bfs(int start) {
		ArrayList<PriorityQueue<Node>> arr = new ArrayList<>();
		
		while (arr.size() != 0) {
			PriorityQueue<Node> q = new PriorityQueue<>();
			for (Node cur : nodes[start].child) {
				q.offer(cur);
			}
		}
		
		
	}
}
