package inflearn.base;

import java.util.Scanner;

public class Section1_String_7 {
	
	public static void solution(String str) {
		String input = str.toUpperCase();
		
		String answer = "YES";
		
		for (int i=0; i<input.length()/2; i++) {
			int lt = i;
			int rt = input.length()-1-i;
			
			if (input.charAt(lt) != input.charAt(rt)) {
				answer = "NO";
				break;
			}
		}
		
		System.out.print(answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solution(sc.next());

		sc.close();
	}

}
