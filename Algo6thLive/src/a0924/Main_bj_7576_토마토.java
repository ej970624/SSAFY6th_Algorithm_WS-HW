package a0924;

import java.io.*;
import java.util.*;

public class Main_bj_7576_토마토 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Point {
		int x, y, day;

		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] box = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<Point> que = new ArrayDeque<>();
		int day = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					que.offer(new Point(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		while (!que.isEmpty()) {
			Point p = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && box[nx][ny] == 0) {
					visited[nx][ny] = true;
					box[nx][ny] = 1;
					que.offer(new Point(nx, ny, p.day+1));
				}
			}
			
			day = p.day;
		}
		
		label : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					day = -1;
					break label;
				}
			}
		}
		
		System.out.println(day);
		br.close();
	}
	
}
