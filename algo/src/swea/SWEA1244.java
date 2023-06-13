package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1244 {
    static int chance;
    static int answer;
    static String[] target;

    public static void main(String[] args) throws NumberFormatException, IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            String input = br.readLine();
            String[] tmp = input.split(" ");

            target = tmp[0].split("");
            chance = Integer.valueOf(tmp[1]);

            answer = 0;
            answer = dfs(0, 0);

            System.out.println("#" + t + " " + answer);
        }
    }

    static int dfs(int k, int count) {
        String temp;
        String targetnum = "";

        if(chance == count) {
            for (String tmp: target) {
                targetnum += tmp;
            }
            if(Integer.valueOf(targetnum) > answer) {
                answer = Integer.valueOf(targetnum);
            }
            return answer;
        }


        for(int i = k; i < target.length; i++) {
            for(int j = i + 1; j < target.length; j++) {

                if (Integer.valueOf(target[i]) <= Integer.valueOf(target[j])) {
                	// 스왑 하는거
                    temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                    dfs(i, count + 1);
                    temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
        }
        return answer;
    }


}