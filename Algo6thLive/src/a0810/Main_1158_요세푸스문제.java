package a0810;

import java.io.*;
import java.util.*;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		sb.append("<");
		while (!que.isEmpty()) {
			for (int i = 1; i < K; i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
		br.close();

	}

}
