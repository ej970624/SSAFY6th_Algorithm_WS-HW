package a0809;

import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_서울_12반_김은지 {
	
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] snack = new int[N];
			boolean[] visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			comb(snack, visited, 2, 0, 0);
			sb.append("#").append(tc+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void comb(int[] a, boolean[] visited, int k, int start, int sum) {
		if (k == 0) {
			if (M >= sum) max = Math.max(max, sum);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (sum > M) return;
			visited[i] = true;
			comb(a, visited, k-1, i+1, sum+a[i]);
			visited[i] = false;
		}
	}

}
