package a0825;

import java.io.*;
import java.util.*;

public class Solution_d4_1251_하나로_MST문제_Prim {
	
	static class Edge implements Comparable<Edge>{
		int n;
		double distance;
		public Edge(int n, double distance) {
			this.n = n;
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
			double result = 0;
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st1.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
				set[i] = new Set(i, i);
 			}
			
			double E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				Edge[] edges = new Edge[N-1];
				int idx = 0;
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					edges[idx++] = new Edge(j, Math.pow(Math.abs(x[i]-x[j]), 2) + Math.pow(Math.abs(y[i]-y[j]), 2));
				}
				for (int j = 0; j < N-1; j++) {
					if (findSet(set, i) != findSet(set, edges[j].n)) {
						union(set, set[i], set[edges[j].n]);
						result += E * edges[i].distance;
						break;
					}
				}
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
