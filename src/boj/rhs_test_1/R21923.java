package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class R21923 {
	static int n, m;
	
	static int[][] arr;
	static long[][] dp_first;
	static long[][] dp_second;
	
	static void first() {
		dp_first[n-1][0] = arr[n-1][0];
		
		for(int i=n-2; i>=0; i--) {
			dp_first[i][0] = arr[i][0]+ dp_first[i+1][0]; 
		}
		
		for(int j=1; j<m; j++) {
			dp_first[n-1][j] = arr[n-1][j]+dp_first[n-1][j-1]; 
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=1; j<m; j++) {
				dp_first[i][j] = arr[i][j] + Math.max(dp_first[i+1][j],dp_first[i][j-1]); 
			}
		}
	}
	
	static void second() {
		dp_second[n-1][m-1] = arr[n-1][m-1];
		
		for(int i=n-2; i>=0; i--) {
			dp_second[i][m-1] = arr[i][m-1] + dp_second[i+1][m-1]; 
		}
		
		for(int j=m-2; j>=0; j--) {
			dp_second[n-1][j] = arr[n-1][j] + dp_second[n-1][j+1]; 
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=m-2; j>=0; j--) {
				dp_second[i][j] = arr[i][j] + Math.max(dp_second[i+1][j],dp_second[i][j+1]); 
			}
		}
	}
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
		n = fr.nextInt();
		m = fr.nextInt();
		arr = new int[n][m];
		dp_first = new long[n][m];
		dp_second = new long[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = fr.nextInt();
			}
		}
		
		first();
		second();
		
		long answer=Long.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				answer = Math.max(answer, dp_first[i][j] + dp_second[i][j]);
			}
		}
		
		System.out.println(answer);
	}
	static class FastReader {
		private BufferedReader br;
		private StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			if(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}