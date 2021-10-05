package a1005;

import java.io.*;
import java.util.*;

public class Main_bj_15961_회전초밥_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //초밥 접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		int[] sushi = new int[N];
		Map<Integer, Integer> num = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if (num.containsKey(sushi[i])) num.put(sushi[i], num.get(sushi[i])+1);
			else {
				num.put(sushi[i], 1);
			}
		}
		int cnt = num.size();
		if (!num.containsKey(c)) cnt++;
		
		int idx = 0;
		for (int i = k; idx < N; i++, idx++) {
			if (num.get(sushi[idx]) == 1) {
				num.remove(sushi[idx]);
			}
			else num.put(sushi[idx], num.get(sushi[idx])-1);
			
			if (i >= N) i -= N;
			
			if (num.containsKey(sushi[i])) num.put(sushi[i], num.get(sushi[i])+1);
			else {
				num.put(sushi[i], 1);
			}
			
			if (!num.containsKey(c)) {
				if (cnt < num.size()+1) cnt = num.size()+1;
			} else if (cnt < num.size()) {
				cnt = num.size();
			}
		}
		System.out.println(cnt);
	}

}
