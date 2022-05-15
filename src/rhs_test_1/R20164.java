package rhs_test_1;

import java.util.Scanner;

public class R20164 {
	static String N;
	static int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
	
	static void DFS(String N, int cnt) {
		int len = N.length(), num = Integer.parseInt(N);
		for(char ch : N.toCharArray()) {
			if((ch-48)%2 == 1) cnt++;
		}
		if(len==1) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
		} else if(len==2) {
			int tmp = num%10;
			num = num/10;
			N = String.valueOf(tmp+num);
			DFS(N, cnt);
		} else {
			for(int i=1; i<len-1; i++) {
				for(int j=i+1; j<=len-1; j++) {
					int f = Integer.parseInt(N.substring(0, i));
					int m = Integer.parseInt(N.substring(i, j));
					int l = Integer.parseInt(N.substring(j));
					
					DFS(String.valueOf(f+m+l),cnt);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		
		DFS(N, 0);
		
		System.out.print(min + " " + max);

	}

}
