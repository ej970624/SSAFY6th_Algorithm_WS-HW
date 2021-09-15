package a0915;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            long answer = 0;
            List<int[]>[] nodes = new ArrayList[V+1];
            boolean[] visited = new boolean[V+1];
            for (int i = 0; i <= V; i++) {
                nodes[i] = new ArrayList<>();
            }
             
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                nodes[a].add(new int[] {b, w});
                nodes[b].add(new int[] {a, w});
            }
             
            int cnt = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
            for (int i = 0; i < nodes[1].size(); i++) {
                pq.add(nodes[1].get(i));
            }
            visited[1] = true;
            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                if (visited[node[0]]) continue;
                visited[node[0]] = true;
                answer += node[1];
                cnt++;
                if (cnt == V-1) break;
                 
                for (int i = 0; i < nodes[node[0]].size(); i++) {
                    pq.add(nodes[node[0]].get(i));
                }
            }
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();

	}
	
}
