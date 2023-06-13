package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int T = 0; T < 10; T++) {
			int t = Integer.parseInt(br.readLine());
			String des = br.readLine();
			String str = br.readLine();
			int cnt = 0;
			
			for(int i = 0; i <= str.length() - des.length(); i++) {
				if(des.equals(str.substring(i, i + des.length()))) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " +cnt);
		}	
	}
}
