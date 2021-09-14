package a0819;

import java.io.*;
import java.util.*;

public class Main_bj_1987_알파벳_서울_12반_김은지 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] alpha;
	static int R, C, max;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[R][C];
		//HashSet사용해도 됨
		//만약 중복을 허용하지 않으면서 순서대로 출력하고 싶다면 -> LinkedHashSet
		
		for (int i = 0; i < R; i++) {
			alpha[i] = br.readLine().toCharArray();
		}
		s = alpha[0][0]+"";
		max = 0;
		dfs(0, 0);
		System.out.println(max);
		br.close();
	}

	static void dfs(int x, int y) {
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (0<=nx && nx<R && 0<=ny && ny<C && !s.contains(alpha[nx][ny]+"")) {
				s += alpha[nx][ny];
				dfs(nx, ny);
				s = s.substring(0, s.length()-1);
			} else {
				max = Math.max(max, s.length());
			}
		}
	}
	
}
