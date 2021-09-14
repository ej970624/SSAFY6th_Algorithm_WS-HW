package a0803;

import java.io.*;

public class Solution_d2_1954_달팽이숫자_서울12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int[] dr = {0, 1, 0, -1}; //우, 하, 좌, 상
		int[] dc = {1, 0, -1, 0};
		
		for (int i = 0; i < tc; i++) {
			int size = Integer.parseInt(br.readLine());
			int[][] snail = new int[size][size];
			sb.append("#").append(i+1).append("\n");
			
			int dIdx = 0;
			int r = 0;
			int c = 0;
			for (int j = 1; j <= size*size; j++) {
				snail[r][c] = j;
				int nr = r+dr[dIdx];
				int nc = c+dc[dIdx];
				if (nr<0 || size<= nr || nc<0 || size<=nc || snail[nr][nc] != 0) dIdx++;
				if (dIdx == dr.length) dIdx = 0;
				r += dr[dIdx];
				c += dc[dIdx];
			}
			
			for (int j = 0; j < snail.length; j++) {
				for (int k = 0; k < snail.length; k++) {
					sb.append(snail[j][k]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
