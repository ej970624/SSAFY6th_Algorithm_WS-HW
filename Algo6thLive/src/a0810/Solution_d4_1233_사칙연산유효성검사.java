package a0810;

import java.io.*;
import java.util.*;

public class Solution_d4_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		outer : for (int tc = 0; tc < 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append("#").append(tc+1).append(" ");
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				if ((idx*2 <= N && !(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))) || (idx*2 > N && (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")))) {
					sb.append("0").append("\n");
					for (int j = i+1; j < N; j++) {
						br.readLine();
					}
					continue outer;
				}
			}
			sb.append("1").append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}
