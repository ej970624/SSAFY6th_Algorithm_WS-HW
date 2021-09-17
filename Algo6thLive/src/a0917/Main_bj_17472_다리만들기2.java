package a0917;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean visited[][], connected[];
	static List<Island> islands;
	static int N, M, country[][];
	
	static class Island {
		int no;
		List<Point> points;
		
		public Island(int no, List<Point> points) {
			this.no = no;
			this.points = points;
		}
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int start, end, dist;

		public Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		country = new int[N][M];
		visited = new boolean[N][M];
		islands = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int no = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (country[i][j] == 1 && !visited[i][j]) {
					islands.add(new Island(no, new ArrayList<>()));
					createIsland(islands.get(no), i, j);
					no++;
				}
			}
		}
		
		PriorityQueue<Edge>[] pq = new PriorityQueue[no];
		connected = new boolean[no];
		
		for (int i = 0; i < no; i++) {
			pq[i] = new PriorityQueue<>((o1, o2)->Integer.compare(o1.dist, o2.dist));
		}
		
		for (int i = 0; i < no; i++) {
			for (int j = 0; j < islands.get(i).points.size(); j++) {
				for (int k = i+1; k < no; k++) {
					for (int l = 0; l < islands.get(k).points.size(); l++) {
						if (islands.get(i).points.get(j).x == islands.get(k).points.get(l).x) {
							int x = islands.get(i).points.get(j).x;
							int start, end;
							boolean flag = true;
							if (islands.get(i).points.get(j).y > islands.get(k).points.get(l).y) {
								start = islands.get(k).points.get(l).y;
								end = islands.get(i).points.get(j).y;
							} else {
								start = islands.get(i).points.get(j).y;
								end = islands.get(k).points.get(l).y;
							}
							for (int m = start+1; m < end; m++) {
								if (country[x][m] != 0) {
									flag = false;
								}
							}
							if (flag) {
								pq[i].add(new Edge(i, k, end-start-1));
								pq[k].add(new Edge(k, i, end-start-1));
							}
						}
						if (islands.get(i).points.get(j).y == islands.get(k).points.get(l).y) {
							int y = islands.get(i).points.get(j).y;
							int start, end;
							boolean flag = true;
							if (islands.get(i).points.get(j).x > islands.get(k).points.get(l).x) {
								start = islands.get(k).points.get(l).x;
								end = islands.get(i).points.get(j).x;
							} else {
								start = islands.get(i).points.get(j).x;
								end = islands.get(k).points.get(l).x;
							}
							for (int m = start+1; m < end; m++) {
								if (country[m][y] != 0) {
									flag = false;
								}
							}
							if (flag) {
								pq[i].add(new Edge(i, k, end-start-1));
								pq[k].add(new Edge(k, i, end-start-1));
							}
						}
					}
				}
			}
		}
		
		PriorityQueue<Edge> connectedQue = new PriorityQueue<>((o1, o2)->Integer.compare(o1.dist, o2.dist));
		connected[0] = true;
		while(!pq[0].isEmpty()) {
			connectedQue.add(pq[0].poll());
		}
		
		int answer = 0;
		while(!connectedQue.isEmpty()) {
			Edge edge = connectedQue.poll();
			
			if (connected[edge.end] || edge.dist < 2) continue;
			
			while(!pq[edge.end].isEmpty()) {
				connectedQue.add(pq[edge.end].poll());
			}
			connected[edge.end] = true;
			
			answer += edge.dist;
		}
		
		for (int i = 0; i < no; i++) {
			if (!connected[i]) answer = -1;
		}
		
		System.out.println(answer);
	}
	
	static void createIsland(Island island, int x, int y) {
		island.points.add(new Point(x, y));
		visited[x][y] = true;
		
		for (int i = 0; i < island.points.size(); i++) {
			Point p = island.points.get(i);
			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && country[nx][ny] == 1) {
					island.points.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

}
