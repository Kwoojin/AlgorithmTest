package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Wedding {
	static int N;
	static ArrayList<Reser> arr;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		Collections.sort(arr);
		
		int answer=Integer.MIN_VALUE, peo=0;
		for(Reser res : arr) {
			if(res.state == 'S') {
				peo++;
				answer = Math.max(answer, peo);
			} else {
				peo--;
			}
		}
		System.out.println(answer);
	}
	
	static void input() {
		Reader rd = new Reader();
		N = rd.nextInt();
		
		arr = new ArrayList<>();
		while(N-- > 0) {
			int s = rd.nextInt();
			int e = rd.nextInt();
			
			arr.add(new Reser(s, 'S'));
			arr.add(new Reser(e, 'E'));
		}
	}
	
	static class Reader {
		BufferedReader br;
		StringTokenizer st;
		
		public Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			if(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	static class Reser implements Comparable<Reser> {
		int time;
		char state;
		public Reser(int time, char state) {
			this.time = time;
			this.state = state;
		}
		
		@Override
		public int compareTo(Reser ob) {
			if (this.time == ob.time) return this.state - ob.state;
			else return this.time - ob.time;
		}
	}
}




