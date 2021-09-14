package a0817;

import java.io.*;
import java.util.*;

public class Main_bj_1074_Z {
	
	static int N, r, c, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		findCnt(0, 0, 1<<N);
		
		System.out.println(cnt);
		
	}

	static void findCnt(int x, int y, int interval) {
		if (interval == 2) {
			for (int i = x; i < x+2; i++) {
				for (int j = y; j < y+2; j++) {
					if (i == r && j == c) return;
					cnt++;
				}
			}
		}
		
		int nx = x+interval/2, ny = y+interval/2;
		if (r >= nx) {
			cnt += interval/2 * interval;
			x = nx;
		} 
		if (c >= ny){
			cnt += interval/2 * interval/2;
			y = ny;
		} 
		findCnt(x, y, interval/2);
	}
}
