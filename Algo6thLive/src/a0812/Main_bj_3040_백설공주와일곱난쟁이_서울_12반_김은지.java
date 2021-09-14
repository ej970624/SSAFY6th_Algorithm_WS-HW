package a0812;

import java.io.*;

public class Main_bj_3040_백설공주와일곱난쟁이_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int R = 7;
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int[] comb = new int[N];
		for (int i = N-1; i >= N-R; i--) {
			comb[i] = 1;
		}
		
		do {
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if (comb[i] == 1) {
					sum += num[i];
					sb.append(num[i]).append("\n");
				}
			}
			if (sum == 100) {
				System.out.println(sb);
				return;
			}
		} while(np(comb));
	}
	
	static boolean np(int[] a) {
		int N = a.length;
		
		int i = N-1;
		while(i>0 && a[i-1]>=a[i]) i--;
		if (i == 0) return false;
		
		int j = N-1;
		while(a[i-1]>=a[j]) j--;
		swap(a, i-1, j);
		
		int k = N-1;
		while(i<k) swap(a, i++, k--);
		
		return true;
	}
	
	static void swap(int[] a, int i, int j) {
		int T = a[i];
		a[i] = a[j];
		a[j] = T;
	}

}
