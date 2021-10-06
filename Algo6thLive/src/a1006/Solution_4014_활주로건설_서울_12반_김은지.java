package a1006;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설_서울_12반_김은지 {
	
	static int N, X, map[][], answer;
	
	static class Info {
		int n, cnt;

		public Info(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				rowFind(i);
				colFind(i);
			}
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void rowFind(int r) {
		int c = 0;
		List<Info> list = new ArrayList<Info>();
		
		while (c<N) {
			int curr = map[r][c];
			int cnt = 0;
			while (c < N && curr == map[r][c]) {
				cnt++;
				c++;
			}
			list.add(new Info(curr, cnt));
		}
		if (vaildCheck(list)) {
			answer++;
		}
	}
	
	static void colFind(int c) {
		int r = 0;
		List<Info> list = new ArrayList<Info>();
		
		while (r<N) {
			int curr = map[r][c];
			int cnt = 0;
			while (r < N && curr == map[r][c]) {
				cnt++;
				r++;
			}
			list.add(new Info(curr, cnt));
		}
		
		if (vaildCheck(list)) {
			answer++;
		}
	}
	
	private static boolean vaildCheck(List<Info> list) {
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i).n + 1 == list.get(i+1).n) { //왼쪽이 더 낮은경우 (1차이)
				if (list.get(i).cnt < X) return false; //더 작은 쪽이 X보다 길이가 짧으면 건설 불가
				list.get(i).cnt -= X;
			} else if (list.get(i).n == list.get(i+1).n + 1) { //오른쪽이 더 낮은 경우 (1차이)
				if (list.get(i+1).cnt < X) return false;
				list.get(i+1).cnt -= X;
			} else { //높이가 2이상 차이나는 경우 활주로 건설 불가
				return false;
			}
		}
		return true;
	}

}
