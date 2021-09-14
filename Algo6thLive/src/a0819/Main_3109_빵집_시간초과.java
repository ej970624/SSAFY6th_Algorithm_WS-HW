package a0819;

import java.io.*;
import java.util.*;

//가스비 줄이고자 근처 빵집 가스관에 파이프를 설치해 훔쳐서 사용
//첫째 열 : 근처 빵집, 마지막 열 : 원웅이 빵집
//처음과 끝을 연결해야함, 중간에 건물이 있으면 설치불가
//각 칸은 오른쪽 위, 옆, 아래로 연결가능
//파이프를 여러개 설치, 겹치면 안되고 접해도 안됨.
//놓을 수 있는 파이프라인의 최대 개수를 출력
public class Main_3109_빵집_시간초과 {
	
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static int R, C, max;
	static boolean[][] selected;
	static Pair[] pairs;
	
	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		selected = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == '.') {
					selected[i][j] = true;
				}
			}
		}
		
		max = 0;
		pipe(0, 0, 0);
		System.out.println(max);
		br.close();
	}

	static void pipe(int r, int c, int cnt) {
		if (c == 0) {
			pairs = new Pair[C];
			pairs[0] = new Pair(r, 0);
		} else if (c == C-1) {
			for (int i = 0; i < C; i++) {
				selected[pairs[i].x][pairs[i].y] = false;
			}
			max = Math.max(max, cnt+1);
			if (pairs[0].x+1 == R) return;
			pipe(pairs[0].x+1, 0, cnt+1);
		}
		
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if (0<=nr && nr<R && 0<=nc && nc<C && selected[r][c] && selected[nr][nc]) {
				pairs[nc] = new Pair(nr, nc);
				pipe(nr, nc, cnt);
			}
		}
		if (c == 0 && selected[pairs[0].x][pairs[0].y]) {
			pipe(pairs[0].x+1, 0, cnt);
		}
	}
}
