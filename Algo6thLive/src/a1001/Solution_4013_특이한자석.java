package a1001;

import java.io.*;
import java.util.*;

public class Solution_4013_특이한자석 {

	static LinkedList<Integer>[] gears;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			gears = new LinkedList[4]; //톱니바퀴의 상태를 저장하는 String배열
			
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				gears[i] = new LinkedList<>();
				for (int j = 0; j < 8; j++) {
					gears[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken())-1; //톱니바퀴의 인덱스 번호
				boolean clockwise = Integer.parseInt(st.nextToken())==1?true:false; //회전하는 방향 (true:시계방향, false:반시계방향)
				
				rotation(idx, clockwise, true, true);
			}
			
			int answer = 0;
			for (int i = 0; i < 4; i++) {
				if (gears[i].poll()== 1)	answer += Math.pow(2, i);
			}
			
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
	
	static void rotation(int idx, boolean clockwise, boolean left, boolean right) {

		//회전할 때 옆 바퀴와 맞닿는 부분은 2, 6인덱스(왼쪽은 2, 오른쪽은 6 확인하기)
		if (left && idx-1 >= 0) {
			if (gears[idx-1].get(2) != gears[idx].get(6)) {
				if (clockwise) { //현재 톱니가 시계방향이면 왼쪽은 반시계방향으로 회전.
					rotation(idx-1, false, true, false);
				} else {
					rotation(idx-1, true, true, false);
				}
			}
		}
		
		if (right && idx+1 < 4) {
			if (gears[idx].get(2) != gears[idx+1].get(6)) {
				if (clockwise) {
					rotation(idx+1, false, false, true);
				} else {
					rotation(idx+1, true, false, true);
				}
			}
		}
		
		if (clockwise) {
			gears[idx].addFirst(gears[idx].pollLast());
		} else {
			gears[idx].addLast(gears[idx].pollFirst());
		}
	}
}
