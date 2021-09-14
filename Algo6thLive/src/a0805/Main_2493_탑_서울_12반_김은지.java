package a0805;

import java.io.*;
import java.util.*;

public class Main_2493_탑_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] tower = new int[cnt];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Info> stack = new Stack<>();
		for (int i = 0; i < cnt; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek().value > tower[i]) {
					sb.append(stack.peek().idx).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) sb.append("0 ");
			stack.push(new Info(i+1, tower[i]));
		}
		System.out.println(sb);
	}

}

class Info {
	int idx;
	int value;
	
	public Info(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}