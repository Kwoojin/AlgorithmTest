package inflearn.base;

import java.util.Scanner;

public class Section1_String_2 {
	
	public static void solution(String str) {
		
		char[] results = new char[str.length()];
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if (Character.isUpperCase(c)) {
				results[i] = Character.toLowerCase(c);
			} else {
				results[i] = Character.toUpperCase(c);
			}
		}
		
		
		System.out.print(new String(results));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		solution(s);
		

	}

}
