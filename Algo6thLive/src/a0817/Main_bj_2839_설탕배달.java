package a0817;

import java.io.*;

public class Main_bj_2839_설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		
		for (int i = 3; i <= N; i++) {
			if (num[i] != 0) continue;
			if (i % 5 == 0) num[i] = i/5;
			else {
				int fiveNum = i / 5;
				int threeNum = 0;
				for (int j = i % 5; j <= i; j+=5) {
					if (j % 3 == 0) {
						threeNum = j / 3;
						break;
					}
					fiveNum--;
				}
				if (threeNum != 0) num[i] = fiveNum + threeNum;
			}
		}
		if (num[N] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(num[N]);
		}
	}

}
