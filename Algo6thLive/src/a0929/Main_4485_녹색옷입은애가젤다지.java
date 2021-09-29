package a0929;

import java.io.*;
import java.util.*;

public class Main_4485_녹색옷입은애가젤다지 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, tc = 1;
		
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] lost = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(lost[i], Integer.MAX_VALUE);
			}
			
			lost[0][0] = map[0][0];
			ArrayDeque<int[]> que = new ArrayDeque<>();
			que.offer(new int[] {0,0});
			
			while (!que.isEmpty()) {
				int[] point = que.poll();
				int x = point[0];
				int y = point[1];
				
				for (int i = 0; i < dx.length; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (0<=nx && nx<N && 0<=ny && ny<N) {
						if (lost[nx][ny] > lost[x][y] + map[nx][ny]) {
							lost[nx][ny] = lost[x][y] + map[nx][ny];
							que.offer(new int[] {nx, ny});
						}
					}
				}
			}
			
			sb.append("Problem ").append(tc++).append(": ").append(lost[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
}
