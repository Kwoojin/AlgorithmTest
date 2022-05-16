package boj.rhs_test_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class R20181 {
	static int N;
	static long K;
	static long[] arr, dy;
	static ArrayList<Food>[] bar;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		for(int i=0; i<N; i++)
			bar[i] = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			long sum=arr[i];
			int j=i+1;
			for(; j<N; j++) {
				if(sum >= K) break;
				sum += arr[j];
			}
			bar[--j].add(new Food(i,sum-K));
		}
		
		if(arr[0] > K) dy[0] = arr[0]-K;
		for(int i=1; i<N; i++) {
			dy[i] = dy[i-1];
			if(bar[i].size() >0) {
				for(Food fd : bar[i]) {
					long tmp = fd.value;
					if(fd.start-1 >= 0) tmp += dy[fd.start-1];
					dy[i] = Math.max(dy[i],tmp);
				}
			}
		}
		
		System.out.print(dy[N-1]);
	}
	
	static void input() {
		FastReader fr = new FastReader();
		
		N = fr.nextInt();
		K = fr.nextInt();
		
		arr = new long[N];
		dy = new long[N];
		bar = new ArrayList[N];
		for(int i=0; i<N; i++) 
			arr[i] = fr.nextInt();
	}
	
	static class Food {
		public int start;
		public long value;
		public Food(int start, long value) {
			this.start = start;
			this.value = value;
		}
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