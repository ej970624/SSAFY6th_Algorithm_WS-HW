package a0917;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서연결하기_서울_12반_김은지 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Point> cores;
	static int N, cells[][], len, answer, connected;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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
			answer = Integer.MAX_VALUE;
			connected = 0;
			cal(0, 0, copy(cells), 0);
			if (answer == Integer.MAX_VALUE) answer = 0;
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void cal(int idx, int sum, int[][] temp, int cnt) { //따지고보면 순열
		if (idx == len) {
			if (cnt < connected) return;
			else if (cnt == connected) answer = Math.min(answer, sum);
			else answer = sum;
			connected = cnt;
			return;
		}
		
		label : for (int i = 0; i < dx.length; i++) {
			int[][] t = copy(temp);
			int nx = cores.get(idx).x + dx[i];
			int ny = cores.get(idx).y + dy[i];
			int dist = 0;
			
			while (0<=nx && nx<N && 0<=ny & ny<N) {
				if (temp[nx][ny] == 1) {
					temp = t;
					continue label;
				}
				temp[nx][ny] = 1;
				nx += dx[i];
				ny += dy[i];
				dist++;
			}
			
			cal(idx+1, sum+dist, temp, cnt+1);			
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
