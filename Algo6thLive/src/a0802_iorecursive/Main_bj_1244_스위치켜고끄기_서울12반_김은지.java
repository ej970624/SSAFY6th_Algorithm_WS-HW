package a0802_iorecursive;

import java.util.*;
import java.io.*;

public class Main_bj_1244_스위치켜고끄기_서울12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] onoff = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			onoff[i] = Integer.parseInt(st.nextToken());
		}
		n = Integer.parseInt(br.readLine());
		int[][] student = new int[n][2];
		
		for (int i = 0; i < student.length; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
			
			if (student[i][0] == 1) {
				int idx = student[i][1];
				while (student[i][1] < onoff.length) {
					onoff[student[i][1]] = (onoff[student[i][1]] == 1)?0:1;
					student[i][1] += idx;
				}
			} else if (student[i][0] == 2){
				onoff[student[i][1]] = (onoff[student[i][1]] == 1)?0:1;
				int cnt = 1;
				while (student[i][1] - cnt > 0 && student[i][1] + cnt < onoff.length) {
					if (onoff[student[i][1]-cnt] == 1 && onoff[student[i][1]+cnt] == 1) {
						onoff[student[i][1]-cnt] = 0;
						onoff[student[i][1]+cnt] = 0;
					} else if (onoff[student[i][1]-cnt] == 0 && onoff[student[i][1]+cnt] == 0) {
						onoff[student[i][1]-cnt] = 1;
						onoff[student[i][1]+cnt] = 1;
					} else {
						break;
					}
					cnt++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		n = 0;
		for (int i = 1; i < onoff.length; i++) {
			sb.append(onoff[i]).append(" ");
			n++;
			if (n % 20 == 0) sb.append("\n");
		}
		System.out.print(sb);
	}

}
