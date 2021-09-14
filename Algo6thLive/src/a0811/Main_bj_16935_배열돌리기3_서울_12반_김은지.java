package a0811;

import java.io.*;
import java.util.*;

public class Main_bj_16935_배열돌리기3_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			N = arr.length;
			M = arr[0].length;
			int[][] temp;
			if (num == 3 || num == 4) temp = new int[M][N];
			else temp = new int[N][M];

			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (num == 1) temp[N - 1 - x][y] = arr[x][y];
					else if (num == 2) temp[x][M - 1 - y] = arr[x][y];
					else if (num == 3) temp[y][N - 1 - x] = arr[x][y];
					else if (num == 4) temp[M - 1 - y][x] = arr[x][y];
					else {
						if ((num == 5 && x < N/2 && y < M/2) || (num == 6 && x >= N/2 && y < M/2)) temp[x][y + M / 2] = arr[x][y];
						else if ((num == 5 && x < N/2 && y >= M/2) || (num == 6 && x < N/2 && y < M/2)) temp[x + N / 2][y] = arr[x][y];
						else if ((num == 5 && x >= N/2 && y < M/2) || (num == 6 && x >= N/2 && y >= M/2)) temp[x - N / 2][y] = arr[x][y];
						else if ((num == 5 && x >= N/2 && y >= M/2) || (num == 6 && x < N/2 && y >= M/2)) temp[x][y - M / 2] = arr[x][y];
					}
				}
			}
			arr = temp;
		}

		for (int[] a : arr) {
			for (int i : a) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
