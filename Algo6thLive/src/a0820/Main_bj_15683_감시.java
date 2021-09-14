package a0820;

import java.io.*;
import java.util.*;

public class Main_bj_15683_감시 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] possible;
	static int[][] room;
	static int N, M, min;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		list = new ArrayList<>();
		possible = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == 0) {
					possible[i][j] = true;
				} else if (room[i][j] < 6){
					list.add(new int[] {i, j, room[i][j]});
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		search(0);
		System.out.println(min);
	}
	
	static void search(int idx) {
		if (idx == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (possible[i][j]) cnt++;
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		
		int[] cctv = list.get(idx);
		boolean[][] temp;
		if (cctv[2] == 1) {
			for (int d = 0; d < 4; d++) {
				temp = copy(possible);
				straight(cctv[0], cctv[1], d);
				search(idx+1);
				possible = copy(temp);
			}
		} else if (cctv[2] == 2) {
			for (int d = 0; d < 2; d++) {
				temp = copy(possible);
				straight(cctv[0], cctv[1], d);
				straight(cctv[0], cctv[1], d+2);
				search(idx+1);
				possible = copy(temp);
			}
		} else if (cctv[2] == 3) {
			for (int d = 0; d < 4; d++) {
				temp = copy(possible);
				straight(cctv[0], cctv[1], d);
				if (d == 3) {
					straight(cctv[0], cctv[1], 0);
				} else {
					straight(cctv[0], cctv[1], d+1);
				}
				search(idx+1);
				possible = copy(temp);
			}
		} else if (cctv[2] == 4) {
			for (int d = 0; d < 4; d++) {
				temp = copy(possible);
				for (int d2 = 0; d2 < 4; d2++) {
					if (d != d2) {
						straight(cctv[0], cctv[1], d2);
					}
				}
				search(idx+1);
				possible = copy(temp);
			}
		} else if (cctv[2] == 5) {
			temp = copy(possible);
			for (int d = 0; d < 4; d++) {
				straight(cctv[0], cctv[1], d);
			}
			search(idx+1);
			possible = copy(temp);
		}
	}
	
	static boolean[][] copy(boolean[][] possible) {
		boolean[][] temp = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = possible[i][j];
			}
		}
		return temp;
	}
	
	static void straight(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		while (0<=nx && nx<N && 0<= ny && ny<M && room[nx][ny] != 6) {
			possible[nx][ny] = false;
			nx += dx[d];
			ny += dy[d];
		}
	}
	
}
