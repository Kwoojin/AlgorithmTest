package boj.rhs_test_1;

import java.util.Scanner;

public class R21920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int x = sc.nextInt();
		long cnt=0, answer=0;
		for(int i=0; i<n; i++) {
			int g = gcd(arr[i], x);
			if(g == 1) {
				answer += arr[i];
				cnt++;
			}
		}
		System.out.printf("%.6f", (double)answer/cnt);
	}
	
	static int gcd(int x, int y) {
		while (y != 0) {
			int tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}
}