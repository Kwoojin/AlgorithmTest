package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

import java.util.PriorityQueue;


public class Income {
	static int N;
	static ArrayList<Lecture> arr;
	
	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		Collections.sort(arr);
		PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
		int day = arr.get(0).day, j=0;
		int answer=0;
		while(day > 0) {
			for(; j<arr.size(); j++) {
				if(day == arr.get(j).day) Q.offer(arr.get(j).money);
				else break;
			}
			if(!Q.isEmpty()) answer += Q.poll();
			--day;
		}
		System.out.println(answer);
	}
	
	static void input() {
		Reader rd = new Reader();
		
		N = rd.nextInt();
		arr = new ArrayList<>();
		while(N-- > 0) {
			int m = rd.nextInt();
			int d = rd.nextInt();
			
			arr.add(new Lecture(m, d));
		}
	}
	
	static class Lecture implements Comparable<Lecture> {
		public int money;
		public int day;
		public Lecture(int money, int day) {
			this.money = money;
			this.day = day;
		}
		
		@Override
		public int compareTo(Lecture ob) {
			return ob.day - this.day;
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
}
