package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1233 {
	static Node1233[] nodeArr;
	static ArrayList<String> check;
	static String before;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int node = Integer.parseInt(br.readLine());
			
			nodeArr = new Node1233[node + 1];
			for (int i = 1; i < node + 1; i++) {
				nodeArr[i] = new Node1233(null, null, null);
			}
			
			for (int i = 1; i < node + 1; i++) {
				String[] tmp = br.readLine().split(" ");
				
				nodeArr[i].data = tmp[1];
				if (tmp.length > 2)
					nodeArr[i].lN = nodeArr[Integer.parseInt(tmp[2])];
				if (tmp.length > 3)
					nodeArr[i].rN = nodeArr[Integer.parseInt(tmp[3])];
			}
			check = new ArrayList<>();
			search(nodeArr[1]);
			int flag = 1;
			before = "0";
			for (String str : check) {
//				System.out.print(str + ":");
				if (before.equals("+") || before.equals("-") || before.equals("/") || before.equals("*")) {
					if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
						flag = 0;
				}
				before = str;
			}
			System.out.println("#" + (t + 1) + " " + flag);
		}
	}
	
	public static void search(Node1233 root) {
		if (root != null) {
			search(root.lN);
			check.add(root.data);
			search(root.rN);
		}
	}

}

class Node1233 {
	String data;
	Node1233 lN;
	Node1233 rN;
	
	public Node1233(String data, Node1233 lN, Node1233 rN) {
		super();
		this.data = data;
		this.lN = lN;
		this.rN = rN;
	}
}
