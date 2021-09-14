package a0809;

import java.io.*;
import java.util.*;

public class Solution_d3_1228_암호문1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<String> secret = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				secret.add(st.nextToken());
			}
			
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					secret.add(x++, st.nextToken());
				}
			} 
			sb.append("#").append(tc+1).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(secret.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}
