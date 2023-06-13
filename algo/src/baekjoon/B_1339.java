package baekjoon;

import java.io.*;
import java.util.*;

public class B_1339 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int [] alpha = new int[26];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            int power = (int) Math.pow(10, arr[i].length() - 1);
            for(int j = 0; j < arr[i].length(); j++){
                alpha[arr[i].charAt(j) - 'A'] += power;
                power /= 10;
            }
        }

        Arrays.sort(alpha);
        int value = 9;
        int sum = 0;
        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum += alpha[i] * value--;
        }
        System.out.println(sum);
    }
}