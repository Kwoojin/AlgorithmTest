package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Stack;

public class R21925 {
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		
		int n = fr.nextInt(), cnt=0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			int num = fr.nextInt();
			if(stack.isEmpty()) {
				stack.push(num);
			} else {
				if(num == stack.peek()) {
					stack.pop();
					if(stack.isEmpty()) cnt++;
				} else {
					stack.push(num);
				}
			}
		}
		if(!stack.isEmpty()) cnt = -1;
		System.out.print(cnt);
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