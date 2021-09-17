package a0917;

import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, space[][], cnt, select[], max;
	static List<Point> empty, virus;
	static boolean[][] visited;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		space = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 0) {
					empty.add(new Point(i, j));
					cnt++;
				} else if (space[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
		
		select = new int[3];
		max = 0;
		comb(0, 0);
		
		System.out.println(max);
	}
	
	static void comb(int k, int start) {
		if (k == 3) {
			visited = new boolean[N][M];
			for (int i = 0; i < 3; i++) {
				Point p = empty.get(select[i]);
				space[p.x][p.y] = 1;
			}
			
			for (int i = 0; i < virus.size(); i++) {
				Point p = virus.get(i);
				bfs(p.x, p.y);
			}
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (space[i][j] != 1 && !visited[i][j]) sum++;
				}
			}
			
			for (int i = 0; i < 3; i++) {
				Point p = empty.get(select[i]);
				space[p.x][p.y] = 0;
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = start; i < cnt; i++) {
			select[k] = i;
			comb(k+1, i+1);
		}
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<Point> que = new ArrayDeque<>();
		que.offer(new Point(x, y));
		visited[x][y] = true;
		
		while (!que.isEmpty()) {
			Point p = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && space[nx][ny] != 1) {
					que.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
	}

}
