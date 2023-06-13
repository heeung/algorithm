package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_16236 {

    static int[][] map;
    static int[] saveArea;
    static int[][] visited;
    static int N;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int cnt, retCnt;
    static int size;
    static ArrayList<Integer> fish;
    static int fishIdx;
    static int eat;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        fish = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //아기상어 위치 저장
                if (map[i][j] == 9)
                    saveArea = new int[]{i, j, 1};
                    //물고기들 크기 저장
                else if (map[i][j] != 0)
                    fish.add(map[i][j]);
            }
        }
        if (fish.size() > 1)
            Collections.sort(fish);

        size = 2;
        while (true) {
            if (fish.size() - fishIdx == 0 || fish.get(fishIdx) >= size)
                break;
            int[] tmpArea = new int[] {saveArea[0], saveArea[1]};
            map[saveArea[0]][saveArea[1]] = 0;
            saveArea = bfs(saveArea[0], saveArea[1]);
            if (tmpArea[0] == saveArea[0] && tmpArea[1] == saveArea[1])
            	break ;
            if (eat == size) {
                size += 1;
                eat = 0;
            }
        }
        System.out.println(retCnt);
    }

    public static int[] bfs(int i, int j) {
        visited = new int[N][N];
//        for (int k = 0; k < N; k++) {
//            Arrays.fill(visited[k], -1);
//        }
        visited[i][j] = 1;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });
        q.offer(saveArea);
        while (!q.isEmpty()) {
            int[] next = q.poll();
            if (map[next[0]][next[1]] != 0 && map[next[0]][next[1]] < size) {
                fishIdx++;
                retCnt += visited[next[0]][next[1]] - 1;
                eat++;
                return next;
            }
            for (int d = 0; d < 4; d++) {
                int nextI = next[0] + dy[d];
                int nextJ = next[1] + dx[d];

                if (nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && visited[nextI][nextJ] == 0
                        && fish.size() != 0 && map[nextI][nextJ] <= size) {
                    visited[nextI][nextJ] = visited[next[0]][next[1]] + 1;
                    int[] nextNode = new int[]{nextI, nextJ, visited[nextI][nextJ]};
//                    if (map[nextNode[0]][nextNode[1]] != 0 && map[nextNode[0]][nextNode[1]] < size) {
//                        fishIdx++;
//                        retCnt += visited[nextNode[0]][nextNode[1]] - 1;
//                        eat++;
//                        return nextNode;
//                    }
                    q.offer(nextNode);
                }
            }
        }
        return saveArea;
    }

    public static boolean isPossible(int i, int j) {
        //먹을수 있는 물고기가 없음
        if (fish.size() == 0)
            return false;
        //다음 진행하려고 하는 곳에 큰 물고기가있어서 못감
        if (map[i][j] > size)
            return false;
        return true;
    }
}
