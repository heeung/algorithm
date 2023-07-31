package baekjoon;

import java.io.*;
import java.util.*;

public class B_2608 {
    static String input1, input2;
    static HashMap<String, Integer> map;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input1 = br.readLine();
        input2 = br.readLine();

        map = new HashMap<>();
        mapping();

        toNumber(input1);
        toNumber(input2);

        System.out.println(sum);
        System.out.println(toWord());
    }

    static void toNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (i < str.length() - 1 && (cur == 'I' || cur == 'X' || cur == 'C')) {
                String tmp = str.substring(i, i + 2);

                if (map.containsKey(tmp)) {
                    sum += map.get(tmp);
                    i++;
                    continue ;
                }
            }
            sum += map.get(Character.toString(cur));
        }
    }

    public static String toWord() {
        StringBuilder sb = new StringBuilder();

        while(sum >= 1000) {
            sb.append("M");
            sum -= 1000;
        }
        if(sum >= 900) {
            sb.append("CM");
            sum -= 900;
        }
        if(sum >= 500) {
            sb.append("D");
            sum -= 500;
        }
        if(sum >= 400) {
            sb.append("CD");
            sum -= 400;
        }
        while(sum >= 100) {
            sb.append("C");
            sum -= 100;
        }
        if(sum >= 90) {
            sb.append("XC");
            sum -= 90;
        }
        if(sum >= 50) {
            sb.append("L");
            sum -= 50;
        }
        if(sum >= 40) {
            sb.append("XL");
            sum -= 40;
        }
        while(sum >= 10) {
            sb.append("X");
            sum -= 10;
        }
        if(sum >= 9) {
            sb.append("IX");
            sum -= 9;
        }
        if(sum >= 5) {
            sb.append("V");
            sum -= 5;
        }
        if(sum >= 4) {
            sb.append("IV");
            sum -= 4;
        }
        while(sum >= 1) {
            sb.append("I");
            sum -= 1;
        }
        return sb.toString();
    }

    static void mapping() {
        map.put("I", 1); map.put("IV", 4); map.put("V", 5);
        map.put("IX", 9); map.put("X", 10); map.put("XL", 40);
        map.put("L", 50); map.put("XC", 90); map.put("C", 100);
        map.put("CD", 400); map.put("D", 500); map.put("CM", 900);
        map.put("M", 1000);
    }
}
