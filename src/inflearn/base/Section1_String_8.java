package inflearn.base;

import java.util.Scanner;

public class Section1_String_8 {
	
	public static void solution(String str) {
		StringBuilder sb = new StringBuilder();
		
		for (char cur: str.toCharArray()) {
			boolean test=Character.isDigit(cur);
			if (!Character.isAlphabetic(cur)) {
				sb.append(cur);
			}
		}
		
		System.out.print(Integer.parseInt(sb.toString()));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solution(sc.next());

		sc.close();
	}

}
