package a0806;

import java.util.*;
import java.io.*;

public class Solution_d4_1861_정사각형방 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int maxCnt, value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] n = new int[N][N];
			value = N*N;
			maxCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					n[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(n, i, j, 1, n[i][j]);
				}
			}
			
			sb.append("#").append(tc+1).append(" ").append(value).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
		br.close();

	}
	
	static void dfs(int[][] n, int x, int y, int cnt, int startValue) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (0<=nx && nx<n.length && 0<=ny && ny<n.length && n[nx][ny] == n[x][y]+1) {
				dfs(n, nx, ny, cnt+1, startValue);
			}
			else {
				if (maxCnt < cnt) {
					maxCnt = cnt;
					value = startValue;
				} else if (cnt == maxCnt) value = Math.min(value, startValue); 
			}
		}
	}

}
