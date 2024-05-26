package inflearn.base;

import java.util.Scanner;

public class Section1_String_1 {
	
	public static void solution(String str, char t) {
		int result = 0;
		
		String copyStr = str.toUpperCase();
		char copyT = Character.toUpperCase(t);
		
		for (char current: copyStr.toCharArray()) {
			if (copyT == current) {
				result++;
			}
		}
		
		System.out.print(result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		char c = sc.next().charAt(0);
		
		solution(s, c);
		

	}

}
