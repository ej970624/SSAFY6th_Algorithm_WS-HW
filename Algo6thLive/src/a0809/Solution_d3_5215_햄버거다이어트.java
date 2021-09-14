package a0809;

import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거다이어트 {

	static int T, N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] info = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			T = 0;
			boolean[] visited = new boolean[N];
			for (int i = 1; i <= N; i++) {
				comb(info, visited, 0, i, 0, 0);
			}

			sb.append("#").append(tc + 1).append(" ").append(T).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

	static void comb(int[][] a, boolean[] visited, int start, int k, int tsum, int ksum) {
		if (k == 0) {
			if (L >= ksum)
				T = Math.max(tsum, T);
			return;
		}

		for (int i = start; i < N; i++) {
			if (L < ksum) return;
			visited[i] = true;
			comb(a, visited, i + 1, k - 1, tsum+a[i][0], ksum+a[i][1]);
			visited[i] = false;
		}
	}

}
