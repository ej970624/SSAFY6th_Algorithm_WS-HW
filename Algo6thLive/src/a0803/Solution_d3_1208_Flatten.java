package a0803;

import java.util.*;
import java.io.*;

public class Solution_d3_1208_Flatten {
	public static void main(String[] args) throws IOException {
		int tc = 10;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		outer : for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			for (int j = 0; j < box.length; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(i+1).append(" ");
			Arrays.sort(box);
			for (int j = 0; j < n; j++) {
				if (box[box.length-1]-box[0] < 2) {
					sb.append(box[box.length-1]-box[0]).append("\n");
					continue outer;
				}
				box[0]++;
				box[box.length-1]--;
				Arrays.sort(box);
			}
			sb.append(box[box.length-1]-box[0]).append("\n");
		}
		System.out.println(sb);
	}
}
