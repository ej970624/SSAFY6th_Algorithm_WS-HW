package a0914;

import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] color = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());
			if (i != 0) {
				color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
				color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
				color[i][2] += Math.min(color[i-1][0], color[i-1][1]);
			}
		}
		
		System.out.println(Math.min(color[N-1][0], Math.min(color[N-1][1], color[N-1][2])));
	}

}
