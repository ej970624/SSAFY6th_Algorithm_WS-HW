package a0820;

import java.io.*;
import java.util.*;

public class Solution_d4_3234_준환이의양팔저울 {
	
	static boolean[] selected;
	static int N, num[], perm[], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = new int[N];
			perm = new int[N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			 answer = 0;
			 perm(0);
			 sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void perm(int cnt) {
		if (cnt == N) {
			subset(perm, 0, 0, 0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			perm[cnt] = num[i];
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}

	static void subset(int[] perm, int idx, int left, int right) {
		if (left < right) return;
		
		if (idx == N) {
			answer++;
			return;
		}
		
		subset(perm, idx+1, left+perm[idx], right);
		subset(perm, idx+1, left, right+perm[idx]);
	}
}
