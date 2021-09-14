package a0810;

import java.util.*;

public class BfsDfs {
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int N=5, cnt;
	static int[][] a;
	static boolean[][] v;

	public static void main(String[] args) {
		a = new int[N][N];
		v = new boolean[N][N];
		cnt = 1;
		dfs(N/2,N/2);
		for (int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
		
		a = new int[N][N];
		v = new boolean[N][N];
		cnt = 1;
		bfs(N/2,N/2);
		for (int[] b:a) System.out.println(Arrays.toString(b));
	}

	static void dfs(int i, int j) {
		v[i][j] = true;
		a[i][j] = cnt++;
		
		for (int d = 0; d < di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i, j});
		v[i][j] = true;
		
		while(!que.isEmpty()) {
			int[] value = que.poll();
			a[value[0]][value[1]] = cnt++;
			for (int d = 0; d < di.length; d++) {
				int ni = value[0]+di[d];
				int nj = value[1]+dj[d];
				if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					que.offer(new int[] {ni, nj});
					v[ni][nj] = true;
				}
			}
		}
	}

}
