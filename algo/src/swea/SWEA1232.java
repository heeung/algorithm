package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1232 {
	static Node1232[] nodeArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int node = Integer.parseInt(br.readLine());
			
			nodeArr = new Node1232[node + 1];
			for (int i = 1; i < node + 1; i++) {
				nodeArr[i] = new Node1232(null, null, null);
			}
			
			for (int i = 1; i < node + 1; i++) {
				String[] str = br.readLine().split(" ");
				nodeArr[i].data = str[1];
				if (str.length > 2)
					nodeArr[i].leftNode = nodeArr[Integer.parseInt(str[2])];
				if (str.length > 3)
					nodeArr[i].rightNode = nodeArr[Integer.parseInt(str[3])];
			}
			System.out.println(dfs(nodeArr[1]));
		}
	}
	
	public static int dfs(Node1232 root) {
		if (root.leftNode != null)
			dfs(root.leftNode);
		if (root.rightNode != null)
			dfs(root.rightNode);
		
		if (root.data.equals("+"))
			return dfs(root.leftNode) + dfs(root.rightNode);
		else if (root.data.equals("-"))
			return dfs(root.leftNode) - dfs(root.rightNode);
		else if (root.data.equals("/"))
			return dfs(root.leftNode) / dfs(root.rightNode);
		else if (root.data.equals("*"))
			return dfs(root.leftNode) * dfs(root.rightNode);
		
		return Integer.parseInt(root.data);
	}
}

class Node1232 {
	String data;
	Node1232 leftNode;
	Node1232 rightNode;
	
	public Node1232(String data, Node1232 leftNode, Node1232 rightNode) {
		super();
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}
