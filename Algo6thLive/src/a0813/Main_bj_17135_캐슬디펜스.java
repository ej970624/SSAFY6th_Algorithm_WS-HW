package a0813;

import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스 {
	
	static final int num = 3;
	static int N, M, D, field[][], archer[], answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		archer = new int[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(answer);
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == num) {
			int[][] f = new int[N][M];
			for(int i=0; i<N; i++){
	            System.arraycopy(field[i], 0, f[i], 0, M);
	        }
			int max = 0;
			while (true) {
				List<int[]> infos = new ArrayList<>();
				int enemyCnt = 0;
				for (int idx = 0; idx < M; idx++) {
					if (archer[idx] == 0) continue;
					int[][] array = new int[N*M][3];
					int arrayIndex = 0;
					for (int i = N-1; i >= 0; i--) {
						for (int j = 0; j < M; j++) {
							if (f[i][j] == 0) continue;
							enemyCnt++;
							int d = N-i+Math.abs(idx-j);
							if (d <= D)	array[arrayIndex++] = new int[] {d, j, i};
						}
					}
					if (arrayIndex == 0) continue;
					else if (arrayIndex > 1) {
						array = Arrays.copyOf(array, arrayIndex);
						Arrays.sort(array, (o1,o2)-> Integer.compare(o1[0],o2[0]) != 0 ? Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1],o2[1]));
					}
					infos.add(array[0]);
				}
				if (enemyCnt == 0) break;
				for (int i = 0; i < infos.size(); i++) {
					if (f[infos.get(i)[2]][infos.get(i)[1]] == 1) {
						max++;
						f[infos.get(i)[2]][infos.get(i)[1]] = 0;
					}
				}
				for (int i = N-1; i > 0; i--) {
					f[i] = f[i-1];
				}
				f[0] = new int[M];
			}
			answer = Math.max(max, answer);
			return;
		}
		
		for (int i = start; i < M; i++) {
			if (archer[i] == 1) continue;
			
			archer[i] = 1;
			comb(cnt+1, i+1);
			archer[i] = 0;
		}
	}

}
