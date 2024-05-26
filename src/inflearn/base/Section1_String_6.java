package inflearn.base;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Section1_String_6 {
	
	public static void solution(String str) {
		StringBuilder answer = new StringBuilder();
		
		Set<Character> input = new HashSet<Character>();
		
		for (char current : str.toCharArray()) {
			if (!input.contains(current)) {
				answer.append(current);
				input.add(current);
			}
		}
		
		System.out.print(answer.toString());
	}
	
	public static void solution2(String str) {
		StringBuilder answer = new StringBuilder();
		
		for (int i=0; i<str.length(); i++) {
			char current = str.charAt(i);
			
			if (str.indexOf(current) == i) {
				answer.append(current);
			}
			
		}
		
		System.out.print(answer.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solution2(sc.next());

		sc.close();
	}

}
