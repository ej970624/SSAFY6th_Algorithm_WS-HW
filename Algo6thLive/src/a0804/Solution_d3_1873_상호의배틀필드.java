package a0804;

import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1, 0, 1, 0}; //상, 우, 하, 좌
		int[] dc = {0, 1, 0, -1};
		Map<Character, Object> dir = new HashMap<>();
		//value값이 int타입
		dir.put('^', 0);
		dir.put('>', 1);
		dir.put('v', 2);
		dir.put('<', 3);
		//value값이 char타입
		dir.put('U', '^');
		dir.put('R', '>');
		dir.put('D', 'v');
		dir.put('L', '<');
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());//3 7
			char[][] field = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			int d = 0; //dr,dc배열의 인덱스
			int r = 0; //field에서 화살표의 행 인덱스
			int c = 0; //field에서 화살표의 열 인덱스
			for (int i = 0; i < field.length; i++) {
				String str = br.readLine(); // str = "***...." -> toCharArray -> ['*', '*', '*', '.', '.', '.', '.'] 
				if (str.contains(">") || str.contains("<") || str.contains("v") || str.contains("^")) {
					r = i; //r = 1;
				}
				field[i] = str.toCharArray();
			}
			
			for (int i = 0; i < field[r].length; i++) {
				if (field[r][i] == '>' || field[r][i] == '<' || field[r][i] == 'v' || field[r][i] == '^') {
					c = i;
					d = (int)dir.get(field[r][i]); //d=1;
					break;
				} 
			}
			
			int N = Integer.parseInt(br.readLine()); //10
			String s = br.readLine(); //SSRUDLDSSL
			for (int i = 0; i < N; i++) { //i = 0
				char key = s.charAt(i); // key = 'S'
				int nr = r+dr[d]; //만약 r=0, c=0, d=1이라면 -> nr = 0+dr[1] = 0+0= 0
				int nc = c+dc[d]; //만약 r=0, c=0, d=1이라면 -> nc = 0+dc[1] = 0+1= 1
				if (key == 'U' || key == 'R' || key == 'D' || key == 'L') { //key='U'
					char arrow = (char) dir.get(key); //arrow='^'
					d = (int) dir.get(arrow); //d=0
					nr = r+dr[d];
					nc = c+dc[d];
					if (0<=nr && nr<field.length && 0<=nc && nc<field[nr].length && field[nr][nc] == '.') {
						field[r][c] = '.';
						field[nr][nc] = arrow;
						r = nr;
						c = nc;
					} else {
						field[r][c] = arrow;
					}
				} else if (key == 'S') {
					while (0<=nr && nr<field.length && 0<=nc && nc<field[nr].length) {
						if (field[nr][nc] == '*') {
							field[nr][nc] = '.';
							break;
						} else if (field[nr][nc] == '#') {
							break;
						}
						nr += dr[d];
						nc += dc[d];
					}
				}
			}
			sb.append("#").append(tc+1).append(" ");
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[i].length; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
