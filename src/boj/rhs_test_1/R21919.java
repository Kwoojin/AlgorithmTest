package boj.rhs_test_1;

import java.util.Scanner;

public class R21919{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long answer=1;
		for(int i=0; i<N; i++) {
			long num = sc.nextInt();
			if(isPrime(num)) {
				answer = lcm(answer, num);
			}
		}
		
		if(answer == 1) System.out.print(-1);
		else System.out.print(answer);
	}
	
	static boolean isPrime(long x){
		for(int i=2; i<=Math.sqrt(x); i++) {
			if(x%i==0) return false;
		}
		return true;
	}
	
	static long gcd(long x, long y) {
		while(y != 0) {
			long tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}
	
	static long lcm(long x, long y) {
		return x / gcd(x, y) * y;
	}
}