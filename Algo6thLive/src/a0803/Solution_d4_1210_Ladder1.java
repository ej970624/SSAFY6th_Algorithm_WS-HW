package a0803;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_1210_Ladder1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 10;
		int[] dr = {-1, 0, 0};
		int[] dc = {0, 1, -1};
		
		for (int i = 0; i < tc; i++) {
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
			int[][] ladder = new int[100][100];
			int r=0, c=0;
			for (int j = 0; j < ladder.length; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < ladder[j].length; k++) {
					int n = Integer.parseInt(st.nextToken());
					if (n==2) {
						r = j;
						c = k;
					}
					ladder[j][k] = n;
				}
			}
			
			int dIdx = 0;
			while (r > 0) {
				int nr = r + dr[dIdx];
				int nc = c + dc[dIdx];
				if (dIdx == 0) {
					if (c>0 && ladder[r][c-1] == 1) dIdx = 2;
					if (c<99 && ladder[r][c+1] == 1) dIdx = 1;
				} else {
					if (nr<0||100<=nr||nc<0||100<=nc) dIdx = 0;
					else {
						if (ladder[nr][nc] == 0 && ladder[r-1][c] == 1) dIdx = 0;
					}
				}
				r += dr[dIdx];
				c += dc[dIdx];
			}
			sb.append(c).append("\n");
		}
		System.out.println(sb);
	}

}
