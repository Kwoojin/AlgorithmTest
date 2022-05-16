package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Meeting {
	static int N;
	static ArrayList<Reser> arr;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		Collections.sort(arr);
		
		int time=0, answer=0;
		for(Reser res : arr) {
			if(time <= res.start) {
				answer++;
				time = res.end;
			}
		}
		
		System.out.print(answer);
	}
	
	static void input() {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		
		arr = new ArrayList<>();
		while(N-- > 0) {
			int s = fr.nextInt();
			int e = fr.nextInt();
			arr.add(new Reser(s, e));
		}
	}
	
	static class FastReader {
		StringTokenizer st;
		BufferedReader br;
		
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
	}
}

class Reser implements Comparable<Reser> {
	public int start;
	public int end;
	public Reser(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Reser ob) {
		if(this.end == ob.end) return this.start - ob.start;
		else return this.end - ob.end;
	}
}