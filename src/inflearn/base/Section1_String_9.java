package inflearn.base;

import java.util.Scanner;

public class Section1_String_9 {
	
	public static void solution(String str, char c) {
		int length = str.length();
		
		int[] answer = new int[length];
		for (int i=0; i<length; i++) {
			answer[i] = Integer.MAX_VALUE;
		}
		
		int pos, start = 0;
		
		while((pos=str.indexOf(c, start))!=-1) {
			for (int i=0; i<length; i++) {
				int distance = Math.abs(i-pos);
				if (answer[i]>distance) {
					answer[i]=distance;
				}
			}
			start = pos+1;
		}
		
		
		for (int cur: answer) {
			System.out.print(cur);
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solution(sc.next(), sc.next().charAt(0));

		sc.close();
	}

}
