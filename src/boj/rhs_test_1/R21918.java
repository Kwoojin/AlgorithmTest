package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class R21918 {
	static FastReader fr;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] arr;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	
	static void process() {
		
		
		while(M-- > 0) {
			int a = fr.nextInt();
			int b = fr.nextInt();
			int c = fr.nextInt();
			switch (a) {
				case 1:
					arr[b] = c;
					break;
				case 2:
					for(int i=b; i<=c; i++) {
						if(arr[i]==1) arr[i]=0;
						else arr[i]=1;
					}
					break;
				case 3:
					for(int i=b; i<=c; i++) arr[i]=0;
					break;
				case 4:
					for(int i=b; i<=c; i++) arr[i]=1;
					break;
				default :
					break;
			}
		}
		
		for(int i=1; i<=N; i++) sb.append(arr[i]).append(' ');
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			
		}
	}
	
	
	static void input() {
		fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) arr[i] = fr.nextInt();
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