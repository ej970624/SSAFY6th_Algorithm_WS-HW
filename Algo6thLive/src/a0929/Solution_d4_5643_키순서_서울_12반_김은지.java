package a0929;

import java.io.*;
import java.util.*;

public class Solution_d4_5643_키순서_서울_12반_김은지 {
	
	static final int INF = 10000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] students = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(students[i], INF);
				students[i][i] = 0;
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				students[a][b] = -1;
				students[b][a] = 1;
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (students[i][j] == INF && students[i][k] == students[k][j]) {
							students[i][j] = students[i][k];
						}
					}
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (students[i][j] == 1 || students[i][j] == -1) cnt++;
				}
				if (cnt == N-1)	answer++;
			}
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
