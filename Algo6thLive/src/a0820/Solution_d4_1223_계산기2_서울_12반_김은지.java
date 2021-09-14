package a0820;

import java.io.*;
import java.util.*;

public class Solution_d4_1223_계산기2_서울_12반_김은지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine(); //중위표기식 문자열 저장
			
			//연산자를 저장할 stack
			Stack<Character> oper = new Stack<>();
			ArrayDeque<Character> que = new ArrayDeque<>(); //후위표기식으로 바꿔서 저장할 String 변수 -> que로 푸는게 좋음
			//후위표기식으로 바꾸는 부분
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) { //피연산자
					que.offer(s.charAt(i));
				} else { //연산자
					//스택이 비어있거나, 현재 연산자 우선순위가 더 높으면 스택에 추가 (현재 > 스택)
					if (oper.isEmpty() || (s.charAt(i) == '*' && oper.peek() == '+')) {
						oper.push(s.charAt(i));
					} else { 
						//현재 연산자 우선순위보다 스택의 연산자 우선순위가 높거나 같을 때 까지만 반복하며 스택에서 pop하여 change에 추가 (현재 <= 스택)
						// -> 나보다 우선순위가 낮은 애가 나오기 전까지 pop
						while(!oper.isEmpty() && !(s.charAt(i) == '*' && oper.peek() == '+')) {
							que.offer(oper.pop());
						}
						//현재 연산자를 스택에 추가
						oper.push(s.charAt(i));
					}
				}
			}
			//스택에 남은 모든 연산자 추가
			while (!oper.isEmpty()) { 
				que.offer(oper.pop()); 
			}
			
			//숫자를 저장할 stack
			Stack<Integer> num = new Stack<>();
			//후위표기식을 계산하는 부분
			while(!que.isEmpty()) {
				char c = que.poll();
				if (c == '+' || c == '*') { //연산자라면 스택에서 2개 pop해서 연산 후 스택에 push
					if (c == '+') {
						num.push(num.pop() + num.pop());
					} else {
						num.push(num.pop() * num.pop());
					}
				} else { //숫자면 스택에 push
					num.push(c-'0');
				}
			}
			
			sb.append("#").append(tc+1).append(" ").append(num.pop()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	

}
