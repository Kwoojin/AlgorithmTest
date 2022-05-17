package boj.rhs_test_1;

import java.util.Scanner;

public class R21921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int sum=0, cnt=0, max=Integer.MIN_VALUE;
		for(int i=0; i<x-1; i++) sum += arr[i];
		
		for(int i=x-1; i<n; i++) {
			sum += arr[i];
			if(max < sum) {
				max = sum;
				cnt = 1;
			} else if (max == sum) {
				cnt++;
			}
			sum -= arr[i-x+1];
		}
		
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}