package a0812;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규영이와인영이의카드게임 {

	static int[] gyu;
	static int[] yu;
	static boolean[] selected;
	static int win, lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			gyu = new int[9];
			yu = new int[9];
			selected = new boolean[19];
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				selected[gyu[i]] = true;
			}
			
			win = 0;
			lose = 0;
			permutation(0);
			sb.append("#").append(tc+1).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void permutation(int cnt) {
		if (cnt == 9) {
			int gyuScore = 0;
			int yuScore = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > yu[i]) gyuScore += gyu[i] + yu[i];
				else yuScore += yu[i] + gyu[i];
			}
			
			if (gyuScore > yuScore) win++;
			else if (yuScore > gyuScore) lose++;
			
			return;
		}
		
		for (int i = 1; i <= 18; i++) {
			if (selected[i]) continue;
			yu[cnt] = i;
			selected[i] = true;
			permutation(cnt+1);
			selected[i] = false;
		}
	}

}
