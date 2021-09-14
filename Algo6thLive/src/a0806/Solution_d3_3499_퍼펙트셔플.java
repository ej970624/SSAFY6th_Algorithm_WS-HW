package a0806;

import java.io.*;
import java.util.*;

public class Solution_d3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		ArrayDeque<String> q = new ArrayDeque<>();
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N/2+N%2; i++) {
				l1.add(st.nextToken());
			}
			for (int i = 0; i < N/2; i++) {
				l2.add(st.nextToken());
			}
			
			while (!l1.isEmpty() || !l2.isEmpty()) {
				if (!l1.isEmpty())	q.offer(l1.remove(0));
				if (!l2.isEmpty())	q.offer(l2.remove(0));
			}
			sb.append("#").append(tc+1).append(" ");
			while (!q.isEmpty()) sb.append(q.poll()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
