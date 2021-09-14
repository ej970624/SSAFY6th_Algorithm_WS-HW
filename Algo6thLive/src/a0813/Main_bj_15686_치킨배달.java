package a0813;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달 {
	
	static int[][] house, chicken;
	static int N, M, hi, ci, distance;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new int[2*N][2]; 
		chicken = new int[13][2];
		
		hi = 0;
		ci = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) house[hi++] = new int[]{i, j};
				if (n == 2) chicken[ci++] = new int[]{i, j};
			}
		}
//		System.out.println(Arrays.deepToString(house));
//		System.out.println(Arrays.deepToString(chicken));
		selected = new boolean[ci];
		distance = Integer.MAX_VALUE;
		if (M > ci) M = ci;
		comb(0, 0);
		System.out.println(distance);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < hi; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < ci; j++) {
					if (!selected[j]) continue;
					min = Math.min(min, Math.abs(house[i][0]-chicken[j][0]) + Math.abs(house[i][1]-chicken[j][1]));
				}
				sum += min;
			}
			distance = Math.min(distance, sum);
			return;
		}
		
		for (int i = start; i < ci; i++) {
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}

}
