package softeer;

import java.io.*;
import java.util.*;

public class Softeer_업무처리 {
    static class Node {
        int parent;
        Queue<Integer> leftQ = new LinkedList<>();
        Queue<Integer> rightQ = new LinkedList<>();

        public Node(int parent) {
            this.parent = parent;
        }
    }
    static int H, K, R, ret;
    static Node[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int amount = (int) Math.pow(2, H + 1);
        graph = new Node[amount];
        for (int i = 1; i < amount; i++) {
            graph[i] = new Node(i / 2);
        }

        // 말단 사원 큐에 넣기
        for (int i = (int) (Math.pow(2, H) - 1); i >= 0; i--) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
//                if (i % 2 == 0) { // 순서대로 왼쪽 오른쪽 넣어야 홀수일때 왼쪽, 짝수일때 오른쪽 꺼냄
                    graph[amount - 1 - i].leftQ.offer(Integer.parseInt(st.nextToken()));
//                }
//                else {
//                    graph[amount - 1 - i].rightQ.offer(Integer.parseInt(st.nextToken()));
//                }
            }
        }

        for (int i = 1; i <= R; i++) {
            for (int num = 1; num < amount; num++) {
                if (i % 2 == 1) { // 홀수 일에는 왼쪽 큐를 확인하고 올린다.
                    int cur = 0;
                    if (!graph[num].leftQ.isEmpty()) {
                        cur = graph[num].leftQ.poll();
                        if (num == 1) {
                            ret += cur;
                            continue ;
                        }
                    } else {
                        continue ;
                    }
                    if (num % 2 == 0) {
                        graph[graph[num].parent].leftQ.offer(cur);
                    } else {
                        graph[graph[num].parent].rightQ.offer(cur);
                    }
                } else { // 짝수 일에는 오른쪽 큐를 확인하고 올린다.
                    int cur = 0;
                    if (!graph[num].rightQ.isEmpty()) {
                        cur = graph[num].rightQ.poll();
                        if (num == 1) {
                            ret += cur;
                            continue ;
                        }
                    } else {
                        continue ;
                    }
                    if (num % 2 == 0) {
                        graph[graph[num].parent].leftQ.offer(cur);
                    } else {
                        graph[graph[num].parent].rightQ.offer(cur);
                    }
                }
            }
        }

        System.out.println(ret);
    }
}
