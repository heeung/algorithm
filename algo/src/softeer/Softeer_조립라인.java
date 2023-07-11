package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Softeer_조립라인 {
    static class Task {
        int time, cost;

        public Task(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
    static int N, sum_a, sum_b;
    static Task[] task_a, task_b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        task_a = new Task[N];
        task_b = new Task[N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int time_a = Integer.parseInt(st.nextToken());
            int time_b = Integer.parseInt(st.nextToken());
            int cost_a = Integer.parseInt(st.nextToken());
            int cost_b = Integer.parseInt(st.nextToken());

            task_a[i] = new Task(time_a, cost_a);
            task_b[i] = new Task(time_b, cost_b);
        }

        st = new StringTokenizer(br.readLine());
        task_a[N - 1] = new Task(Integer.parseInt(st.nextToken()), -1);
        task_b[N - 1] = new Task(Integer.parseInt(st.nextToken()), -1);

        goTask();
        System.out.println(Math.min(sum_a, sum_b));
    }

    static void goTask() {
        int pre_a = 0, pre_b = 0;

        int i = 0;
        while (i < N - 1) {
            sum_a = Math.min(task_a[i].time + pre_a, task_b[i].time + task_b[i].cost + pre_b);
            sum_b = Math.min(task_b[i].time + pre_b, task_a[i].time + task_a[i].cost + pre_a);
            pre_a = sum_a;
            pre_b = sum_b;
            i++;
        }

        sum_a += task_a[N - 1].time;
        sum_b += task_b[N - 1].time;
    }
}
