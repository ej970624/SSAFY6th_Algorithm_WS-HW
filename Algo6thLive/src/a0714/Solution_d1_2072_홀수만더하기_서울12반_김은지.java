package a0714;

import java.io.*;
import java.util.*;

public class Solution_d1_2072_홀수만더하기_서울12반_김은지 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int sum = 0;
			
			for (int i=0; i<10; i++) {
				int n = sc.nextInt();
				if (n % 2 == 1) {
					sum += n;
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
		sc.close();
	}
}
