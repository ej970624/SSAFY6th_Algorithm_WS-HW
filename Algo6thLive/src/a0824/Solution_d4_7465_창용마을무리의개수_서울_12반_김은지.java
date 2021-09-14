package a0824;

import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_서울_12반_김은지 {
	
	static boolean[] visited;
	static List<Integer>[] linked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			linked = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				linked[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				linked[n1].add(n2);
				linked[n2].add(n1);
			}
			
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i);
					answer++;
				}
			}
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}

	static void dfs(int idx) {
		List<Integer> list = linked[idx];
		int size = list.size();
		
		for (int i = 0; i < size; i++) {
			if (!visited[list.get(i)]) {
				visited[list.get(i)] = true;
				dfs(list.get(i));
			}
		}
	}
}
