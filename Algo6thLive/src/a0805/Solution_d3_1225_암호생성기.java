package a0805;

import java.util.*;
import java.io.*;

public class Solution_d3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayDeque<Integer> que = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			
			outer : while(true) {
				for (int i = 1; i <= 5; i++) {
					int n = que.poll()-i;
					if (n <= 0) {
						n = 0;
						que.offer(n);
						break outer;
					}
					que.offer(n);
				}
			}
			sb.append("#").append(tc+1).append(" ");
			for(Integer q: que) sb.append(q).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
}
