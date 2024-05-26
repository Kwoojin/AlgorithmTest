package inflearn.base;

import java.util.Scanner;

public class Section1_String_3 {
	
	public static void solution(String str) {
		String[] splits = str.split(" ");
		
		int length = Integer.MIN_VALUE;
		String result = "";
		
		for (String cur: splits) {
			if (length < cur.length()) {
				length = cur.length();
				result = cur;
			}
		}
		
		System.out.print(result);
		
	}
	
	public static void solution2(String str) {
		str = str + ' ';
		
		String result = "";
		int length = Integer.MIN_VALUE, pos;
		
		while((pos=str.indexOf(' ')) != -1) {
			if (length < pos) {
				length = pos;
				result = str.substring(0, pos);
			}
			
			str = str.substring(pos+1, str.length());
		}
		
		System.out.print(result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		solution2(s);
		

	}

}
