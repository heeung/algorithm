package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 기본 사이즈 2 -> 가신보다 큰 물고기만 먹을 수 있다.
 * 2. 크기가 같으면 지나갈 수는 있다.
 * 3. 먹을 수 있는 물고기가 많으면 거리가 가장 가까운
 *      3.1 같다면 -> 가장 위에 가장 왼쪽
 * 4. 크기가 같을때까지 먹으면 크기가 1 증가
 */
public class B_16236_sub {

    static class Shark {
        int x, y;
        // 기본 상어 값
        int size = 2;
        int eat = 0;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // 먹은거 초기화
        public void clearEat() {
            eat = 0;
        }
        public void sizeUp() {
            size++;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }


        @Override
        public int compareTo(Fish o) {
            if (o.distance == this.distance) {
                // 가장 위, 가장 왼쪽
                if (o.x == this.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.distance - o.distance;
        }
    }

    static int[][] map;
    static Shark shark;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        // init values
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                // 상어의 위치
                if (input == 9) {
                    shark = new Shark(i, j);
                }
                map[i][j] = input;
            }
        }
        int time = 0;
        // 상어 물고기 먹기
        while (true) {
            // 먹을 수 잇는 물고기들 구하기
            PriorityQueue<Fish> eatable = findFish(shark);
            // 먹을 수 있는 물고기가 없음
            if (eatable.isEmpty()) break;
            // 우선 순위에 따라 먹으려는 물고기
            Fish target = eatable.poll();
            // 상어 이동
            map[shark.x][shark.y] = 0;
            map[target.x][target.y] = 0;
            shark.x = target.x;
            shark.y = target.y;
            // 물고기 먹은 후 size 만큼 넘게 먹었다면
            shark.eat += 1;
            if (shark.size <= shark.eat) {
                shark.clearEat();
                shark.sizeUp();
            }
            // 물고기의 거리만큼 시간 증가
            time += target.distance;
        }
        System.out.println(time);
    }

    private static PriorityQueue<Fish> findFish(Shark shark) {
        PriorityQueue<Fish> eatableList = new PriorityQueue<>();
        boolean[][] visited = new boolean[map.length][map.length];
        Queue<Fish> queue = new LinkedList<>();
        queue.offer(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;
        while (!queue.isEmpty()) {
            Fish fish = queue.poll();
            // 먹을 수 있는 물고기 확인
            if (1 <= map[fish.x][fish.y] && map[fish.x][fish.y] < shark.size) {
                eatableList.offer(fish);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int cx = fish.x + dx[i];
                int cy = fish.y + dy[i];
                // 이동 할 수 있는지 확인
                if (checkRange(cx, cy) && map[cx][cy] <= shark.size) {
                    if (!visited[cx][cy]) {
                        visited[cx][cy] = true;
                        queue.offer(new Fish(cx, cy, fish.distance + 1));
                    }
                }
            }
        }
        return eatableList;
    }

    private static boolean checkRange(int x, int y) {
        return (0 <= x && x < map.length && 0 <= y && y < map.length);
    }
}