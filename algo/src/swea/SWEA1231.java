package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231 {
	
	static int[][] insert;
	static Node[] nodeArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			int edge = Integer.parseInt(br.readLine());
			insert = new int[edge][4];
			nodeArr = new Node[edge + 1];
			
			for (int i = 0; i < edge; i++) {
				String str = br.readLine();
				st = new StringTokenizer(str);
				int data = Integer.parseInt(st.nextToken());
				int cData = (int) st.nextToken().charAt(0);
				int lNode = 0;
				int rNode = 0;
				if (st.hasMoreTokens())
					lNode = Integer.parseInt(st.nextToken());
				if (st.hasMoreTokens())
					rNode = Integer.parseInt(st.nextToken());
				
				nodeArr[i + 1] = new Node(data, (char)cData, lNode, rNode);
			}
			System.out.print("#" + (t + 1) + " ");
			inorder_traverse(1);
			System.out.println();
		}
	}
	
	public static void inorder_traverse(int n) {
		if (nodeArr[n] != null) {
			inorder_traverse(nodeArr[n].getLeftNode());
			System.out.print(nodeArr[n].getcData());
			inorder_traverse(nodeArr[n].getRightNode());
		}
	}

}

class Node {
	private int data;
	private char cData;
	private int leftNode;
	private int rightNode;
	
	
	public Node(int data, char cData, int leftNode, int rightNode) {
		super();
		this.data = data;
		this.cData = cData;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public char getcData() {
		return this.cData;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(int leftNode) {
		this.leftNode = leftNode;
	}

	public int getRightNode() {
		return rightNode;
	}

	public void setRightNode(int rightNode) {
		this.rightNode = rightNode;
	}

	public void setcData(char cData) {
		this.cData = cData;
	}
}
