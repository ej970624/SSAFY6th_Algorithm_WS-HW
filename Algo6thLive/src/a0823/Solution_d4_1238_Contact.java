package a0823;

import java.io.*;
import java.util.*;

public class Solution_d4_1238_Contact {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			Map<Integer, List<Integer>> edge = new HashMap<>();
			Map<Integer, Boolean> visited = new HashMap<>();
			ArrayDeque<int[]> que = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if (!edge.containsKey(s)) {
					edge.put(s, new LinkedList<>());
					visited.put(s, false);
				}
				if (!edge.containsKey(e)) {
					edge.put(e, new LinkedList<>());
					visited.put(e, false);
				}
				edge.get(s).add(e);
			}
			
			visited.put(start, true);
			que.offer(new int[] {start, 0});
			int answer = start;
			int depth = 0;
			while(!que.isEmpty()) {
				int[] q = que.poll();
				List<Integer> list = edge.get(q[0]);
				
				for (int i = 0; i < list.size(); i++) {
					int key = list.get(i);
					if (visited.containsKey(key) && !visited.get(key)) {
						visited.put(key, true);
						que.offer(new int[] {key, q[1]+1});
						if (depth < q[1]+1) {
							answer = key;
							depth = q[1]+1;
						} else if (depth == q[1]+1 && answer < key) {
							answer = key;
						}
					}
				}
			}
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
