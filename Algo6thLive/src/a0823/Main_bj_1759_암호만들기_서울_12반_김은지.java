package a0823;

import java.io.*;
import java.util.*;

//최소 모음 1개, 최소 자음 2개
//정렬 순이어야 암호임
public class Main_bj_1759_암호만들기_서울_12반_김은지 {
	
	static int L, C;
	static boolean[] selected;
	static char[] alpha;
	static String vowels = "aeiou";
	static List<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		selected = new boolean[C];
		answer = new ArrayList<String>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		comb(0, 0, 0, 0);
		Collections.sort(answer);
		for (String s : answer) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int start, int consonantsCnt, int vowelsCnt) {
		if (cnt == L) {
			if (consonantsCnt < 2 || vowelsCnt < 1) return;
			char[] input = new char[L];
			int idx = 0;
			for (int i = 0; i < C; i++) {
				if (selected[i]) input[idx++] = alpha[i];
			}
			Arrays.sort(input);
			StringBuilder sb = new StringBuilder();
			for (char c : input) {
				sb.append(c);
			}
			answer.add(sb.toString());
			return;
		}
		
		for (int i = start; i < C; i++) {
			selected[i] = true;
			if (vowels.contains(alpha[i]+"")) {
				comb(cnt+1, i+1, consonantsCnt, vowelsCnt+1);
			} else {
				comb(cnt+1, i+1, consonantsCnt+1, vowelsCnt);
			}
			selected[i] = false;
		}
	}

}
