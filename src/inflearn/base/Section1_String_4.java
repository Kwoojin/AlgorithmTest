package inflearn.base;

import java.util.Scanner;

public class Section1_String_4 {
	
	public static void solution(String str) {
		char[] result = str.toCharArray();
		
		for (int i=0; i<str.length()/2; i++) {
			result[i] = str.charAt(str.length()-1-i);
			result[str.length()-1-i] = str.charAt(i);
		}
		
		System.out.println(new String(result));
	}
	
	public static void solution2(String str) {
		char[] result = str.toCharArray();
		
		int lt=0, rt=str.length()-1;
		while(lt<rt) {
			char tmp = result[lt];
			result[lt] = result[rt];
			result[rt] = tmp;
			
			lt++;
			rt--;
		}
		
		System.out.println(new String(result));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		
		for (int i=0; i<len; i++) {
			solution2(sc.next());
		}

	}

}
