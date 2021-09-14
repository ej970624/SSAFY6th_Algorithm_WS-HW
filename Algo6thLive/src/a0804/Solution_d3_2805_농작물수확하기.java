package a0804;

import java.io.*;

public class Solution_d3_2805_농작물수확하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int plus = 0;
			int idx = N/2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					if (idx-plus<=j && j<=idx+plus)	sum += Integer.parseInt(s.charAt(j)+"");
				}
				if (idx <= i) plus--;
				else plus++;
			}
			sb.append("#").append(tc+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
