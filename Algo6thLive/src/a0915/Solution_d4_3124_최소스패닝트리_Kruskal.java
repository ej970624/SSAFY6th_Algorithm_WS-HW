package a0915;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_Kruskal {
	
	static class Node {
		int n, parent;

		public Node(int n, int parent) {
			this.n = n;
			this.parent = parent;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			long answer = 0;
			Node[] nodes = new Node[V+1];
			for (int i = 1; i <= V; i++) {
				nodes[i] = new Node(i, i);
			}
			
			PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			while (cnt < V-1) {
				int[] edge = edges.poll();
				if (find(nodes, edge[0]) == find(nodes, edge[1])) continue;
				union(nodes, edge[0], edge[1]);
				answer += edge[2];
				cnt++;
			}
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();

	}
	
	static int find(Node[] nodes, int i) {
		Node n = nodes[i];
		while (n.n != n.parent) {
			n = nodes[n.parent];
		}
		return n.parent;
	}
	
	static void union(Node[] nodes, int i, int j) {
		nodes[find(nodes, i)].parent = nodes[find(nodes, j)].parent;
	}

}
