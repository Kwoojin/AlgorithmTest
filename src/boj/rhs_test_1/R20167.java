package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class R20167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int answer=0;
		int lt=0, rt=0, sum=0;
		while(rt<N) {
			sum+=arr[rt++];
			if(sum >= K) {
				int compSum = sum, nlt=lt, nrt=rt;
				while(compSum>=K) compSum-=arr[nlt++];
				while(compSum<K && nrt<N) compSum+=arr[nrt++];
				
				if(sum < compSum) {
					lt=nlt;
					rt=nrt;
					sum=compSum;
				}
				answer += (sum-K);
				lt=rt;
				sum=0;
			}
		}
		if(sum>K) answer += (sum-K);
		
		System.out.print(answer);
	}
}
