package a0825;

import java.io.*;
import java.util.*;

public class Main_bj_10026_적록색약_서울_12반_김은지 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	static char[][] c;
	static boolean[][] check1, check2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		c = new char[N][N];
		check1 = new boolean[N][N];
		check2 = new boolean[N][N];
		int answer1 = 0, answer2 = 0;
		
		for (int i = 0; i < N; i++) {
			c[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check1[i][j]) {
					check1[i][j] = true;
					dfs(i, j, c[i][j], 1);
					answer1++;
				}
				if (!check2[i][j]) {
					check2[i][j] = true;
					dfs(i, j, c[i][j], 2);
					answer2++;
				}
			}
		}
		sb.append(answer1).append(" ").append(answer2);
		System.out.println(sb);
		br.close();
		
	}
	
	static void dfs(int x, int y, char color, int checkNum) {
		for (int d = 0; d < dx.length; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (0<=nx && nx<N && 0<=ny && ny<N) {
				if (checkNum == 1 && !check1[nx][ny] && c[nx][ny] == color) {
					check1[nx][ny] = true;
					dfs(nx, ny, color, checkNum);
				} else if (checkNum == 2 && !check2[nx][ny] && (c[nx][ny] == color || (c[nx][ny] == 'R' && color == 'G') || (c[nx][ny] == 'G' && color == 'R'))) {
					check2[nx][ny] = true;
					dfs(nx, ny, color, checkNum);
				}
			}
		}
	}

}
