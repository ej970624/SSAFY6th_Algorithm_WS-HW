package a0818;

import java.io.*;

public class Main_bj_1992_쿼드트리_서울_12반_김은지 {
	
	static StringBuilder sb;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		quadtree(N, 0, 0);
		System.out.println(sb);
		br.close();
	}

	static void quadtree(int n, int x, int y) {
		char key = arr[x][y];
		boolean flag = true;
		label : for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (key != arr[i][j]) {
					sb.append("(");
					quadtree(n/2, x, y);
					quadtree(n/2, x, y+n/2);
					quadtree(n/2, x+n/2, y);
					quadtree(n/2, x+n/2, y+n/2);
					sb.append(")");
					flag = false;
					break label;
				}
			}
		}
		if (flag) sb.append(Integer.parseInt(key+""));
	}
}
