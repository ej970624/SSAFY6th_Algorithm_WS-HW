package a0824;

import java.io.*;
import java.util.*;

public class DijkstraTest_sc {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] distance = new int[N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				g[i][j] = sc.nextInt();
			}
			distance[i] = Integer.MAX_VALUE;
		}

		distance[0] = 0;

		for (int i = 0; i < N; ++i) {
			// a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;

			for (int j = 0; j < N; ++j) {
				if (!v[j] && min > distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}

			v[minVertex] = true; // 선택 정점 방문 처리

			if (minVertex == N - 1)
				break;// 선택 정점이 도착정점이면 탈출.

			// b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[minVertex][j] != 0 && distance[j] > min + g[minVertex][j]) {
					distance[j] = min + g[minVertex][j];
				}
			}
		}
		System.out.println(distance[N - 1]);
	}
}