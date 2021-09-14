package a0802_iorecursive;

import java.io.*;

public class Solution_d3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tc; i++) {
			String s = br.readLine();
			char key = '0';
			int cnt = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != key) {
					cnt++;
					key = s.charAt(j);
				}
			}
			sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
