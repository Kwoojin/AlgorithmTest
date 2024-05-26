package inflearn.base;

import java.util.Scanner;

public class Section1_String_5 {
	
	public static void solution(String str) {
		char[] result = str.toCharArray();
		
		int lt=0, rt= str.length()-1;
		
		while(lt<rt) {
			boolean firstIsAlphabet = Character.isAlphabetic(result[lt]);
			boolean secondIsAlphabet = Character.isAlphabetic(result[rt]);
			
			if (firstIsAlphabet && secondIsAlphabet) {
				char tmp = result[lt];
				result[lt] = result[rt];
				result[rt] = tmp;
				
				lt++;
				rt--;
			} else if (firstIsAlphabet) {
				rt--;
			} else if (secondIsAlphabet) {
				lt++;
			} else {
				lt++;
				rt--;
			}
		}
		
		System.out.print(new String(result));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solution(sc.next());

		sc.close();
	}

}
