package a0923;

import java.io.*;
import java.util.*;

public class Main_jo_1681_해밀턴순환회로_서울_12반_김은지 {
	
	static int N, cost[][], min, input[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		input = new int[N];
		input[0] = 0;
		perm(1, 0);
		System.out.println(min);
		br.close();
	}

	static void perm(int cnt, int sum) {
		if (sum > min) return;
		
		if (cnt == N) {
			if (cost[input[N-1]][0] == 0) return;
			sum += cost[input[cnt-1]][0];
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (visited[i] || cost[input[cnt-1]][i] == 0) continue;
			
			input[cnt] = i;
			visited[i] = true;
			perm(cnt+1, sum+cost[input[cnt-1]][input[cnt]]);
			visited[i] = false;
		}
	}
}
