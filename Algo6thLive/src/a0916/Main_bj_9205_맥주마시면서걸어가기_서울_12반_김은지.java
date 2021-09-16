package a0916;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기_서울_12반_김은지 {
	
	static final int INF = 1000000000;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			Point[] points = new Point[n+2];
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int[][] dist = new int[n+2][n+2];
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if (i == j) continue;
					dist[i][j] = Math.abs(points[i].x-points[j].x)+Math.abs(points[i].y-points[j].y);
					if (dist[i][j] > 1000) dist[i][j] = INF;
				}
			}
			
			for (int k = 0; k < n+2; k++) { //k번 노드를 중간 노드로 삼을 때와 아닐 때의 값을 비교하여 작은 값으로 업데이트
				for (int i = 0; i < n+2; i++) {
					for (int j = 0; j < n+2; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			if (dist[0][n+1] != INF) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
