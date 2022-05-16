package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Wrestling {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Player> arr;
	static int N;

	public static void main(String[] args) {
		input();
		process();
	}
	
	static void process() {
		Collections.sort(arr);
		
		int max = Integer.MIN_VALUE, answer=0;
		for(Player peo : arr) {
			if(max < peo.weight) {
				max = peo.weight;
				answer++;
			}
		}
		
		System.out.println(answer);
	}	
	
	static void input() {
		try {
			N = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			
			StringTokenizer st;
			while(N-- > 0) {
				st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr.add(new Player(h, w));
			}
		} catch (IOException e) {
			
		}
	}
	
	static class Player implements Comparable<Player> {
		public int height;
		public int weight;
		
		public Player(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Player ob) {
			return ob.height - this.height;
		}
	}

}

