package a0810;

import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if (paper[j][k] == 0) {
						paper[j][k] = 1;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
