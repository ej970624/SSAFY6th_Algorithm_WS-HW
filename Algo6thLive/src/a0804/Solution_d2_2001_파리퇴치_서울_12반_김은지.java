package a0804;

import java.io.*;
import java.util.*;

public class Solution_d2_2001_파리퇴치_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] n = new int[N][N];
			int[][] m = new int[N-(M-1)][N-(M-1)];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					n[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					for (int k = i; k < i+M; k++) {
						for (int l = j; l < j+M; l++) {
							m[i][j] += n[k][l];
						}
					}
					max = Math.max(max, m[i][j]);
				}
			}
			sb.append("#").append(tc+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
