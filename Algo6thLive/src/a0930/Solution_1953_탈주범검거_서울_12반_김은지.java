package a0930;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거_서울_12반_김은지 {
	
	static int[] dx = {-1, 0, 1, 0}; //상우하좌
	static int[] dy = {0, 1, 0, -1};
	static int cnt, N, M, L, tunnel[][];
	static boolean[][] visited;
	
	static class Point {
		int x, y, before;

		public Point(int x, int y, int before) {
			this.x = x;
			this.y = y;
			this.before = before;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //터널 세로
			M = Integer.parseInt(st.nextToken()); //터널 가로
			int R = Integer.parseInt(st.nextToken()); //맨홀 세로
			int C = Integer.parseInt(st.nextToken()); //맨홀 가로
			L = Integer.parseInt(st.nextToken()); //소요된 시간
			
			tunnel = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tunnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			visited = new boolean[N][M];
			bfs(R, C);
			sb.append("#").append(tc+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void bfs(int r, int c) {
		ArrayDeque<Point> que = new ArrayDeque<>();
		que.offer(new Point(r, c, -1));
		
		while (L-- > 0) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point p = que.poll();
				if (visited[p.x][p.y]) continue;
				
				int type = tunnel[p.x][p.y];
				if (p.before != -1 && 
					((p.before == 0 && (type == 3 || type == 4 || type == 7)) ||
					(p.before == 1 && (type == 2 || type == 4 || type == 5)) || 
					(p.before == 2 && (type == 3 || type == 5 || type == 6)) || 
					(p.before == 3 && (type == 2 || type == 6 || type == 7)))) continue;
				
				cnt++;
				visited[p.x][p.y] = true;
				if (type < 4) {
					for (int d = 0; d < dx.length; d++) {
						if (type == 2 && d % 2 == 1) continue;
						if (type == 3 && d % 2 == 0) continue;
						
						int nx = p.x + dx[d];
						int ny = p.y + dy[d];
						
						if (0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && tunnel[nx][ny] != 0) {
							que.offer(new Point(nx, ny, d));
						}
					}
				} else {
					for (int d = 0; d < 2; d++) {
						int idx = type-4+d;
						if (idx == 4) {
							idx = 0;
						} 
						int nx = p.x + dx[idx];
						int ny = p.y + dy[idx];
						if (0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && tunnel[nx][ny] != 0) {
							que.offer(new Point(nx, ny, idx));
						}
					}
				}
			}
		}
	}

}
