package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA1248 {
	static class Node {
		int data;
		int parent;
		Node left;
		Node right;
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	static Node[] tree;
	static int node, edge, n1, n2, cnt; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			tree = new Node[node + 1];
			for (int i = 1; i <= node; i++) {
				tree[i] = new Node(i, null, null);
			}
			st = new StringTokenizer(br.readLine());
			// 트리 완성하기
			for (int i = 0; i < edge; i++) {
				int num = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				if (tree[num].left == null) {
					tree[num].left = tree[child];
					tree[child].parent = num;
				}
				else {
					tree[num].right = tree[child];
					tree[child].parent = num;
				}
			}
			ArrayList<Integer> ret1 = getParents(n1);
			ArrayList<Integer> ret2 = getParents(n2);
			
			int n = find(ret1, ret2);
			// 제일 가까운 공통 조상은 n 번째
			cnt = 0;
			countChilds(tree[n]);
			System.out.printf("#%d %d %d\n", t, n, cnt);
		}
	}
	
	public static ArrayList<Integer> getParents(int num) {
		ArrayList<Integer> ret = new ArrayList<>();
		
		while (tree[num].parent != 0) {
			ret.add(tree[num].parent);
			num = tree[num].parent;
		}
		
		
//		for (Integer k : ret) {
//			System.out.print(k + " ");
//		}
//		System.out.println();
		return ret;
	}

	public static void countChilds(Node n) {
		cnt++;
		if (n.left != null) {
			countChilds(n.left);
		}
		if (n.right != null) {
			countChilds(n.right);
		}
	}
	
	public static int find(ArrayList<Integer> ret1, ArrayList<Integer> ret2) {
		int n = 0;
		for (int i = ret1.size() - 1; i >= 0; i--) {
			for (int j = ret2.size() - 1; j >= 0; j--) {
				if (ret1.get(i).equals(ret2.get(j))) {
					n = ret1.get(i);
				}
			}
		}
		return n;
	}
}
