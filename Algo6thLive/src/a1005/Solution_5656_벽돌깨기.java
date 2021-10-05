package a1005;

import java.util.*;
import java.io.*;

public class Solution_5656_벽돌깨기 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, W, H, bricks[][], min;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			bricks = new int[H][W];
			min = H*W;
			flag = false;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					bricks[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			breakBricks(N, bricks);
			sb.append("#").append(tc+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void breakBricks(int n, int[][] a) { //dfs
		if (flag) return;
		
		if (n == 0) {
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (a[i][j] > 0) cnt++;
				}
			}
			min = Math.min(min, cnt);
			if (min == 0) {
				flag = true;
			}
			return;
		}
		
		int[][] t = new int[H][W];
		boolean none = true;
		label : for (int j = 0; j < W; j++) {
			copyarr(a, t);
			for (int i = 0; i < H; i++) {
				if (t[i][j] > 0) {
					none = false;
					int size = t[i][j];
					for (int d = 0; d < dx.length; d++) {
						t[i][j] = 0;
						spreadAround(t, i, j, d, size-1);
					}
					down(t);
					breakBricks(n-1, t);
					continue label;
				}
			}
		}
		if (none) breakBricks(0, t);
	}
	
	static void spreadAround(int[][] a, int x, int y, int d, int n) {
		if (n <= 0) return;
		
		for (int i = 1; i <= n; i++) {
			int nx = x+dx[d]*i;
			int ny = y+dy[d]*i;
			if (0<=nx && nx<H && 0<=ny && ny<W) {
				int size = a[nx][ny];
				a[nx][ny] = 0;
				if (size > 1) {
					for (int j = 0; j < dx.length; j++) {
						spreadAround(a, nx, ny, j, size-1);
					}
				}
			}
		}
	}
	
	static void copyarr(int[][] a, int[][] t) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				t[i][j] = a[i][j];
			}
		}
	}
	
	static void down(int[][] a) {
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H-1; i++) {
				if (a[i][j] > 0 && a[i+1][j] == 0) {
					for (int k = i+1; k > 0; k--) {
						a[k][j] = a[k-1][j];
					}
					a[0][j] = 0;
				}
			}
		}
	}

}
