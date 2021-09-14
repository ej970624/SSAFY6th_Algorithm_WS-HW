package a0819;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution_d5_1247_최적경로 {
	
	static boolean[] visited;
	static int N, numbers[], min;
	static Point company, house, customers[], before;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine()); //고객의 수
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Point[N]; 
			
			visited = new boolean[N]; //순열에 사용할 방문 체크 배열
			numbers = new int[N]; //방문하는 순서를 저장하는 배열 (고객의 인덱스 값으로 저장)
			
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			min = Integer.MAX_VALUE/2; //min값 초기화
			//이전 방문한 곳을 저장하는 Point타입 before변수 (회사에서 출발하므로 초기값을 회사로 설정)
			before = company; 
			perm(0, 0);
			sb.append("#").append(tc+1).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	
	static void perm(int cnt, int sum) {
		//현재까지의 순열이 min값보다 크다면 더이상 고를 필요 없음 -> return (가지치기)
		//가지치기는 함수 젤 위에!!
		if (sum > min) return; 
		
		if (cnt == N) {
			//min을 현재 min값과 sum에 마지막 고객~집 까지의 거리를 더한 값 중에 더 작은 값으로 갱신
			min = Math.min(min, sum + Math.abs(customers[numbers[N-1]].x-house.x) + Math.abs(customers[numbers[N-1]].y-house.y));
		}
		
		for (int i = 0; i < N; i++) {
			//이미 고른 고객이라면 패스
			if (visited[i]) continue; 
			
			//현재 고객을 선택
			numbers[cnt] = i;
			visited[i] = true;
			
			//현재 선택한 고객과 이전 고객과의 거리
			int d = Math.abs(before.x-customers[i].x) + Math.abs(before.y-customers[i].y);
			
			//재귀끝나고 돌아왔을 때 현재의 before를 다시 before로 설정해줘야 하므로 temp에 저장
			Point temp = before; 
			//재귀 타기 전 현재 고객을 before로 설정
			before = customers[i];
			//sum에 d를 더한 값을 sum으로 바꿔주며 재귀호출
			perm(cnt+1, sum+d);
			
			//이번 고객을 선택하지 않는 것으로 돌아왔으니 아까 저장해둔 temp를 before로 지정
			before = temp; 
			visited[i] = false;
		}
	}

}
