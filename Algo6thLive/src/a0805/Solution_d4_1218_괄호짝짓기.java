package a0805;

import java.util.*;
import java.io.*;

public class Solution_d4_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		Map<Character, Character> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map.put('>','<');
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		
		outer : for (int tc = 0; tc < 10; tc++) {
			int size = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < size; i++) {
				char c = s.charAt(i);
				if (c == '<' || c == '(' || c == '[' || c == '{') stack.push(c);
				else {
					if (stack.isEmpty()) {
						sb.append("#").append(tc+1).append(" 0\n");
						continue outer;
					} else {
						if (stack.pop() != map.get(c)) {
							sb.append("#").append(tc+1).append(" 0\n");
							continue outer;
						}
					}
				}
			}
			if (stack.isEmpty()) sb.append("#").append(tc+1).append(" 1\n");
			else sb.append("#").append(tc+1).append(" 0\n");
		}
		System.out.println(sb);
	}

}
