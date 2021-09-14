package a0825;

import java.io.*;
import java.util.*;

public class Solution_d4_1251_하나로_MST문제_Kruskal {
	
	static class Edge implements Comparable<Edge>{
		int n1, n2;
		double distance;
		public Edge(int n1, int n2, double distance) {
			this.n1 = n1;
			this.n2 = n2;
			this.distance = distance;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
	}
	
	static class Set {
		int n;
		int parent;
		public Set(int n, int parent) {
			this.n = n;
			this.parent = parent;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] x = new int[N];
			int[] y = new int[N]; 
			Set[] set = new Set[N];
			int size = 0;
			double result = 0;
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st1.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
				set[i] = new Set(i, i);
				if (i > 0) size += i;
 			}
			
			Edge[] edges = new Edge[size];
			double E = Double.parseDouble(br.readLine());
			
			int idx = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double d = Math.pow(Math.abs(x[i]-x[j]), 2) + Math.pow(Math.abs(y[i]-y[j]), 2);
					edges[idx++] = new Edge(i, j, d);
				}
			}
			
			Arrays.sort(edges);
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				if (cnt == N-1) break;
				int n1 = edges[i].n1;
				int n2 = edges[i].n2;
				if (findSet(set, n1) == findSet(set, n2)) continue;
				union(set, set[n1], set[n2]);
				result += E * edges[i].distance;
				cnt++;
			}
			
			sb.append("#").append(tc+1).append(" ").append((long)Math.round(result)).append("\n");
		}
		System.out.println(sb);
		br.close();

	}
	
	static int findSet(Set[] setarr, int idx) {
		Set set = setarr[idx];
		while (set.parent != set.n) {
			set = setarr[set.parent];
		}
		return set.parent;
	}
	
	static void union(Set[] setarr, Set n1, Set n2) {
		setarr[findSet(setarr, n2.n)].parent = setarr[findSet(setarr, n1.n)].parent;
	}

}
