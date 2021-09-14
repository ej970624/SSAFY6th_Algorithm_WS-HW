package a0817;

import java.util.*;
import java.io.*;

public class Main_jo_1828_냉장고_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] substance = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			substance[i][0] = Integer.parseInt(st.nextToken());
			substance[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(substance, (o1, o2)->Integer.compare(o1[0], o2[0])==0?-Integer.compare(o1[1], o2[1]):Integer.compare(o1[0], o2[0]));
		int temperature = substance[0][1];
		int answer = 1;
		for (int i = 1; i < N; i++) {
			if (substance[i][0] > temperature) {
				temperature = substance[i][1];
				answer++;
			} else if (substance[i][1] < temperature) {
				temperature = substance[i][1];
			}
		}
		System.out.println(answer);
	}

}
