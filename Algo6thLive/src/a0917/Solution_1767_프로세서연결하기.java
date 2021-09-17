package a0917;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서연결하기 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Point> cores;
	static int N, cells[][], len, answer, connected;
	
	static class Point {
		int x, y, cnt;
		List<Integer> dist;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			dist = new ArrayList<>();
			cnt = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			cells = new int[N][N];
			cores = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cells[i][j] = Integer.parseInt(st.nextToken());
					if (cells[i][j] == 1 && 0<i && i<N-1 && 0<j && j<N-1) cores.add(new Point(i, j));
				}
			}
			
			len = cores.size();
			for (int i = 0; i < len; i++) {
				Point p = cores.get(i);
				for (int j = 0; j < dx.length; j++) {
					dfs(p, p.x+dx[j], p.y+dy[j], j);
				}
			}
			
			answer = Integer.MAX_VALUE;
			connected = 0;
			cal(0, 0, copy(cells), 0);
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(Point p, int x, int y, int d) {
		if (cells[x][y] == 1) return;
		
		if (x == 0 || x == N-1 || y == 0 || y == N-1) {
			p.dist.add(d);
			p.cnt++;
			return;
		}
		
		int nx = x+dx[d];
		int ny = y+dy[d];
		dfs(p, nx, ny, d);
	}
	
	static void cal(int idx, int sum, int[][] temp, int cnt) { 
		if (idx == len) {
			if (cnt < connected) return;
			else if (cnt == connected) answer = Math.min(answer, sum);
			else answer = sum;
			connected = cnt;
			return;
		}
		
		label : for (int i = 0; i < cores.get(idx).cnt; i++) {
			int[][] t = copy(temp);
			int nx = cores.get(idx).x + dx[cores.get(idx).dist.get(i)];
			int ny = cores.get(idx).y + dy[cores.get(idx).dist.get(i)];
			int n = 0;
			while (0<=nx && nx<N && 0<=ny & ny<N) {
				if (temp[nx][ny] == 1) {
					temp = t;
					continue label;
				}
				temp[nx][ny] = 1;
				nx += dx[cores.get(idx).dist.get(i)];
				ny += dy[cores.get(idx).dist.get(i)];
				n++;
			}
			
			cal(idx+1, sum+n, temp, cnt+1);			
			temp = t;
		}
		cal(idx+1, sum, temp, cnt);
	}
	
	static int[][] copy(int[][] a) {
		int[][] t = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				t[i][j] = a[i][j];
			}
		}
		return t;
	}

}
