package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_2668 {
	public static boolean[] visited;
    public static int[] arr;
    public static int N;
    public static ArrayList<Integer> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(list.size());
        for (int x : list) {
            System.out.println(x);
        }

    }
	
	public static void dfs(int i, int start) {
        if (arr[i] == start)
        	list.add(start);

        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i], start);
            visited[arr[i]] = false;
        }
    }

}
